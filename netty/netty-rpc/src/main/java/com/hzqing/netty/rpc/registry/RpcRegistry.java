package com.hzqing.netty.rpc.registry;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolver;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * @author hzqing
 * @date 2019-12-16 09:14
 */
public class RpcRegistry {

    private int port;

    public RpcRegistry(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        new RpcRegistry(8080).start();
    }

    private void start() {

        try {

            // 初始化主线程池，Selector
            EventLoopGroup boosLoopGroup = new NioEventLoopGroup();

            // 子线程池初始化，具体对应客户端的处理逻辑
            EventLoopGroup workLoopGroup = new NioEventLoopGroup();

            ServerBootstrap server = new ServerBootstrap();

            server.group(boosLoopGroup, workLoopGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            // 在Netty中，把所有的业务逻辑处理全部归宗到一个队列中

                            // 这个对立中包含了各种各样的处理逻辑，对这些处理逻辑在Netty中有一个封装。

                            // 封装了一个对象，无锁化串行任务队列
                            // Pipline


                            ChannelPipeline pipeline = ch.pipeline();


                            // 就是对我们处理逻辑的封装


                            // 对于自定义协议的内容进行编码、解码
                            pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
                            // 自定义编码器
                            pipeline.addLast(new LengthFieldPrepender(4));

                            // 实参处理
                            pipeline.addLast("encoder", new ObjectEncoder());

                            pipeline.addLast("decoder", new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));

                            // 最后执行自己的逻辑
                            // 1、注册 给每一个对象定义一个名称，对外提供服务的名字
                            // 2、服务位置进行记录
                            pipeline.addLast(new RegistryHander());


                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);


            // 正式启动服务，相当用一个死循环开始轮训
            ChannelFuture future = server.bind(this.port).sync();
            System.out.println(" Rpc Registry start listen at " + this.port);
            future.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
