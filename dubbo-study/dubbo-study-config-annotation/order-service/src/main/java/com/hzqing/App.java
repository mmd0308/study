package com.hzqing;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author hzqing
 * @date 2019-07-25 10:39
 */

public class App {

    @Configuration
    @EnableDubbo(scanBasePackages = "com.hzqing")
    @PropertySource("classpath:/dubbo-consumer.properties")
    @ComponentScan(value = {"com.hzqing"})
    static public class ConsumerConfiguration {

    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        configApplicationContext.start();
        PayService payService = (PayService) configApplicationContext.getBean("payService");
        String lll = payService.toPay("注解方式订单服务调用支付服务");
        System.out.println(lll);


    }
}
