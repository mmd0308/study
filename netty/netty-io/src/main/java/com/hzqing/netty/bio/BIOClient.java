package com.hzqing.netty.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;

/**
 * @author hzqing
 * @date 2019-12-04 09:18
 */
public class BIOClient {
    public static void main(String[] args) throws IOException {
        // 客户端根据ip和端口连接服务器端
        Socket socket = new Socket("localhost",8080);
        OutputStream outputStream = socket.getOutputStream();

        // 客户端发送给服务端的数据
        String msg = UUID.randomUUID().toString();

        // 给服务端写入信息
        outputStream.write(msg.getBytes());
        outputStream.close();
        socket.close();
    }
}
