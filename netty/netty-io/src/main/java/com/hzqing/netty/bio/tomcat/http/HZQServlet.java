package com.hzqing.netty.bio.tomcat.http;

/**
 * @author hzqing
 * @date 2019-12-25 14:34
 */
public abstract class HZQServlet {

    public void service(HZQRequest request, HZQResponse response){
        if ("GET".equalsIgnoreCase(request.getMethod())){
            doGet(request,response);
        }else {
            doPost(request,response);
        }
    }

    protected abstract void doPost(HZQRequest request, HZQResponse response);

    protected abstract void doGet(HZQRequest request, HZQResponse response);
}
