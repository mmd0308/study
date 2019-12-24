package com.hzqing.netty.bio.demo1;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author hzqing
 * @date 2019-12-04 09:14
 */
public class BIOServer {
    public static void main(String[] args) throws IOException {
        // 创建服务端网络IO模型的封装对象 端口：8080
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true){
            // 等待客户端的连接，阻塞IO
            // Socket 是数据发送者个服务端的引用
            Socket accept = serverSocket.accept();

            // 读取客户端发送的数据
            InputStream inputStream = accept.getInputStream();

            byte[] bytes = new byte[1024];
            int read = inputStream.read(bytes);
            if (read > 0){
                String str = new String(bytes,0,read);
                System.out.println("客户端的端口是："+ accept.getPort()+", 客户端发送的信息是: " + str);
            }
        }
    }
}
