package com.hzqing.netty.rpc.consumer;

import com.hzqing.netty.rpc.api.IHelloService;
import com.hzqing.netty.rpc.provider.HelloServiceImpl;

/**
 * @author hzqing
 * @date 2019-12-16 09:13
 */
public class HelloConsumer {

    public static void main(String[] args) {

        IHelloService helloService = HelloProxy.create(IHelloService.class);
        final String msg = helloService.say("hzqing");
        System.out.println(msg);
    }

}
