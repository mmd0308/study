package com.hzqing.netty.rpc.consumer;

import com.hzqing.netty.rpc.api.IHelloService;
import com.hzqing.netty.rpc.protocol.InvokerProtocol;
import com.hzqing.netty.rpc.registry.RegistryHander;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author hzqing
 * @date 2019-12-16 10:24
 */
@SuppressWarnings("all")
public class HelloProxy {

    public static<T> T create(Class<?> clazz) {
        InvocationHandler proxy = new MethodProxy(clazz);
        final T result = (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, proxy);
        return result;
    }


    // 将本地调用，修改成网络调用
    private static class MethodProxy implements InvocationHandler{

        private Class<?> clazz;

        public MethodProxy(Class<?> clazz) {
            this.clazz = clazz;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            if (Object.class.equals(method.getDeclaringClass())){
                return method.invoke(this,args);
            } else  {
                return rpcInvoker(proxy,method,args);
            }
        }

        private Object rpcInvoker(Object proxy, Method method, Object[] args) {
            // 1. 构造一个协议的内容，消息
            InvokerProtocol msg = new InvokerProtocol();
            msg.setClassName(this.clazz.getName());
            msg.setMethodName(method.getName());
            msg.setParams(method.getParameterTypes());
            msg.setValues(args);

            final ConsumerHander consumerHander = new ConsumerHander();

            // 2. 发起网络请求
            EventLoopGroup worker = new NioEventLoopGroup();

            try {

                Bootstrap client = new Bootstrap();
                client.group(worker)
                        .channel(NioSocketChannel.class)
                        .option(ChannelOption.TCP_NODELAY, true)
                        .handler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel ch) throws Exception {
                                ChannelPipeline pipeline = ch.pipeline();

                                pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
                                pipeline.addLast(new LengthFieldPrepender(4));

                                // 实参处理
                                pipeline.addLast("encoder", new ObjectEncoder());

                                pipeline.addLast("decoder", new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));

                                // 最后执行自己的逻辑
                                // 1、注册 给每一个对象定义一个名称，对外提供服务的名字
                                // 2、服务位置进行记录
                                pipeline.addLast(consumerHander);
                            }
                        });

                ChannelFuture future = client.connect("localhost", 8080).sync();
                future.channel().writeAndFlush(msg).sync();
                future.channel().closeFuture().sync();
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                worker.shutdownGracefully();
            }
            return consumerHander.getResponse();
        }
    }
}
