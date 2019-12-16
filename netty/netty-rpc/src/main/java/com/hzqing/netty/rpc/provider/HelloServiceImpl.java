package com.hzqing.netty.rpc.provider;

import com.hzqing.netty.rpc.api.IHelloService;

/**
 * @author hzqing
 * @date 2019-12-16 09:10
 */
public class HelloServiceImpl implements IHelloService {

    @Override
    public String say(String msg) {
        return "hello " + msg;

    }
}
