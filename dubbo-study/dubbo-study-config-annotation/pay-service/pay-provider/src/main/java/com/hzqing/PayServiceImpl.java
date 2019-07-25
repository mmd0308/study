package com.hzqing;

import org.apache.dubbo.config.annotation.Service;

/**
 * @author hzqing
 * @date 2019-07-25 10:00
 */
@Service
public class PayServiceImpl implements IPayService {

    @Override
    public String pay(String info) {
        System.out.println("pay-service ...");
        return "Hello Dubbo  Annotation " + info;
    }
}
