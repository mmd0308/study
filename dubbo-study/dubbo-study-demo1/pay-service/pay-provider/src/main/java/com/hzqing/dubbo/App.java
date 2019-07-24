package com.hzqing.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author hzqing
 * @date 2019-07-24 16:58
 */
public class App {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("META-INF/spring/application.xml");
        classPathXmlApplicationContext.start();
        System.in.read();
    }
}
