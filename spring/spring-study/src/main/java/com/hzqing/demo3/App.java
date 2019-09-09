package com.hzqing.demo3;


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
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/hzqing/demo3/application.xml");
        User user1 = ctx.getBean("user1", User.class);
        user1.tosay();
        System.out.println(user1);
        User user2 = ctx.getBean("user2",User.class);
        user2.tosay();
        System.out.println(user2);
    }
}
