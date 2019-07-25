package com.hzqing;

/**
 * @author hzqing
 * @date 2019-07-25 09:10
 */
public class PayServiceImpl implements IPayService {
    @Override
    public String pay(String info) {
        System.out.println("pay-service ....");
        return "Hello Dubbo " + info;
    }
}
