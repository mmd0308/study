package com.hzqing.netty.bio.tomcat.http;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author hzqing
 * @date 2019-12-25 14:35
 */
public class HZQRequest {

    /**
     * 请求方式：Get,Post
     */
    private String method;
    /**
     * 用户请求路径
     */
    private String url;

    public HZQRequest(InputStream inputStream) {
        try {
            // 获取http协议的内容
            String content = "";
            byte [] buffer = new byte[1024];
            int len = 0;
            if ((len = inputStream.read(buffer)) > 0 ){
                content = new String(buffer,0,len);
            }

            // 获取第一行数据 GET /first.do HTTP/1.1
            String line = content.split("\\n")[0];

            // 获取method和url
            String arr[] = line.split("\\s");
            this.method = arr[0];
            this.url = arr[1];

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }
}
