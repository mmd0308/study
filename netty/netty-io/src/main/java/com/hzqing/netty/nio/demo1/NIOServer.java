package com.hzqing.netty.nio.demo1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author hzqing
 * @date 2019-12-24 10:28
 */
@SuppressWarnings("all")
public class NIOServer {

    // 服务端的端口
    private int port;

    // 1、轮训器
    private Selector selector;

    // 2、缓冲区
    private ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

    public NIOServer(int port) {
        try {
            this.port = port;

            final ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

            // 设置服务端端口
            serverSocketChannel.bind(new InetSocketAddress(this.port));

            // 为了兼容BIO,所以NIO默认采用的是阻塞是IO。开启非阻塞
            serverSocketChannel.configureBlocking(false);

            // 初始化轮询器
            selector = Selector.open();

            //
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private void listen() {
        try {
            System.out.println("服务器端启动完成，监听端口是：" + this.port);
            // 轮询主线程
            while (true) {
                selector.select();
                final Set<SelectionKey> keys = selector.selectedKeys();
                final Iterator<SelectionKey> iterator = keys.iterator();;
                // 每次只对一个key进行处理，同步执行
                while (iterator.hasNext()){
                    // 每一个key代表一种状态
                    final SelectionKey key = iterator.next();
                    iterator.remove();
                    // 进行实际的业务操作
                    process(key);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 根据key的状态进行不同的逻辑处理
     * 在同一时间点，只能进行一件事情处理，同步处理机制
     * @param key
     * @throws IOException
     */
    private void process(SelectionKey key) throws IOException {
        // 针对每一种状态进行不同的处理

        if (key.isAcceptable()){
            ServerSocketChannel server = (ServerSocketChannel) key.channel();
            // 这里体现了非阻塞，不管数据是否准备好，都需要给我一个状态和反馈。
            SocketChannel client = server.accept();
            client.configureBlocking(false);
            // 当数据准备就绪之后，修改成可读的
            client.register(selector,SelectionKey.OP_READ);

        }else if (key.isReadable()){
            // key.channel(); 从多路复用器中拿到客户端的引用
            SocketChannel client = (SocketChannel) key.channel();
            int len = client.read(byteBuffer);
            if (len > 0) {
                byteBuffer.flip();
                String msg = new String(byteBuffer.array(),0,len);
                System.out.println("服务器端读取到客户端的数据是：" + msg);
            }
        }

    }


    public static void main(String[] args) {
        new NIOServer(8080).listen();
    }

}
