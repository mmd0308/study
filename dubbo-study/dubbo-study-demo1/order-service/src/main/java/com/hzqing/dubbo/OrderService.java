package com.hzqing.dubbo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hzqing
 * @date 2019-07-24 16:49
 */
public class OrderService {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");

        IPayService payService = applicationContext.getBean(IPayService.class);
        // 远程调用
        String res = payService.pay("订单服务调用支付！");
        System.out.println(res);
    }
}
