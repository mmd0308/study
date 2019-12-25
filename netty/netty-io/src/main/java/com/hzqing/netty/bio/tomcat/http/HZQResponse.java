package com.hzqing.netty.bio.tomcat.http;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author hzqing
 * @date 2019-12-25 14:35
 */
public class HZQResponse {

    private  OutputStream outputStream;

    public HZQResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
    public void write(String msg){
        // 用http协议
        // 封装返回内容
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 200 OK\n")
                .append("Content-Type: text/html;\n")
                .append("\r\n")
                .append(msg);
        try {
            outputStream.write(sb.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
