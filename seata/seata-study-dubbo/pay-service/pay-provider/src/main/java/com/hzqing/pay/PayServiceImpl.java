package com.hzqing.pay;

import org.apache.dubbo.config.annotation.Service;

/**
 * @author hzqing
 * @date 2019-08-05 22:06
 */
@Service
public class PayServiceImpl implements IPayService {
    @Override
    public String pay(String num) {
        System.out.println("支付服务接口被调用...");
        return "支付：" + num;
    }
}
