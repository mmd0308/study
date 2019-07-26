package com.hzqing.hello;

import com.hzqing.IHelloService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author hzqing
 * @date 2019-07-26 16:04
 */
@Service
public class HelloServiceImpl implements IHelloService {

    @Override
    public String sayHello() {
        return "Hello Dobble";
    }
}
