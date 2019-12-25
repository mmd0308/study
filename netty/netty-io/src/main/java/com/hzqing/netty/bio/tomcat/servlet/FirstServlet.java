package com.hzqing.netty.bio.tomcat.servlet;

import com.hzqing.netty.bio.tomcat.http.HZQRequest;
import com.hzqing.netty.bio.tomcat.http.HZQResponse;
import com.hzqing.netty.bio.tomcat.http.HZQServlet;

/**
 * @author hzqing
 * @date 2019-12-25 14:33
 */
public class FirstServlet  extends HZQServlet {
    @Override
    protected void doPost(HZQRequest request, HZQResponse response) {
        response.write("This is FirstServlet!");
    }

    @Override
    protected void doGet(HZQRequest request, HZQResponse response) {
        this.doPost(request,response);
    }
}
