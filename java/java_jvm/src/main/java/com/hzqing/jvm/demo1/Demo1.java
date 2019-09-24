package com.hzqing.jvm.demo1;

import java.sql.DriverManager;

/**
 * @author hzqing
 * @date 2019-09-23 14:42
 */
public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());

        classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);

        ClassLoader classLoader1 = Demo1.class.getClassLoader();
        System.out.println(classLoader1);

        System.out.println(String.class.getClassLoader());

    }
}

class Demo{
    public static final int x = 3;
}
