package com.hzqing.demo5;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hzqing
 * @date 2019-09-09 08:19
 */

public class App {
    @Test
    public void test1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/hzqing/demo5/application.xml");
        User user = ctx.getBean("user", User.class);
        user.tosay();
        System.out.println(user);
    }
}
