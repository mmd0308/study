package com.hzqing.cluster;

import org.apache.dubbo.config.annotation.Service;

/**
 * @author hzqing
 * @date 2019-07-31 10:44
 */
@Service(cluster = "failsafe")
public class HelloServiceImpl implements IHelloService {

    @Override
    public String SayHello() {
        String str = "Hello Dubbo 集群容错";
        System.out.println(str);
        return str;
    }
}
