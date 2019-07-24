package com.hzqing.dubbo;

/**
 * @author hzqing
 * @date 2019-07-24 16:35
 */
public class PayServiceImpl implements IPayService {
    @Override
    public String pay(String info) {
        System.out.println("pay-service ....");
        return "Hello Dubbo " + info;
    }
}
