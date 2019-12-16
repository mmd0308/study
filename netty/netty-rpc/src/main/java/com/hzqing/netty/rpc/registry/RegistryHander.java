package com.hzqing.netty.rpc.registry;

import com.hzqing.netty.rpc.protocol.InvokerProtocol;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hzqing
 * @date 2019-12-16 09:32
 */
public class RegistryHander extends ChannelInboundHandlerAdapter {

    private List<String> classNames = new ArrayList<String>();

    private Map<String,Object> registryMap = new ConcurrentHashMap<>();






    public RegistryHander() {
        // 1. 根据一个包名将所有符合条件的class全部扫描出来，放到一个容器中
        //如果分布式，读取配置文件
        scannerClass("com.hzqing.netty.rpc.provider");

        // 2. 给每一个对应的class起一个唯一的名字，作为服务名称，保存到一个
        doRegistry();
    }

    private void doRegistry() {
        if (classNames.isEmpty()){return;}


        for (String className : classNames) {
            try {

                final Class<?> clazz = Class.forName(className);
                Class<?> inter = clazz.getInterfaces()[0];
                String serviceName = inter.getName();

                // 应该存储的网络路径，调用的时候进行解析
                registryMap.put(serviceName,clazz.newInstance());
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    // 正常应该读取配置文件
    // 扫描指定包的文件
    private void scannerClass(String packageName) {
        final URL resource = this.getClass().getClassLoader().getResource(packageName.replaceAll("\\.", "/"));
        File classPath = new File(resource.getFile());

        for (File file : classPath.listFiles()) {
            if (file.isDirectory()){
                scannerClass(packageName + "." + file.getName());
            } else {
                classNames.add(packageName + "." + file.getName().replaceAll(".class",""));
            }
        }


    }

    // 有客户端连接上的时候，会回掉
    // 3. 当有客户端连接过来之后，就会获取协议内容 InvokerProtocol的对象
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        Object result = new Object();

        InvokerProtocol request = (InvokerProtocol) msg;

        // 4. 要去注册号的容器中找到符合条件服务
        if (registryMap.containsKey(request.getClassName())){
            final Object service = registryMap.get(request.getClassName());
            final Method method = service.getClass().getMethod(request.getMethodName(),request.getParams());
            result = method.invoke(service, request.getValues());

        }

        // 5. 通过远程调用Provider得到返回结果，并回复给客户端


        ctx.write(result);
        ctx.flush();
        ctx.close();
    }


    // 连接发生异常的时候
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {


    }
}
