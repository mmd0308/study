package com.hzqing.singleton;

/**
 * @author hzqing
 * @date 2019-07-01 10:00
 */
public class StaticInnerClassTest {
    public static void main(String[] args) {
        StaticInnerClassSingleton singleton1 = StaticInnerClassSingleton.getInstance();
        StaticInnerClassSingleton singleton2 = StaticInnerClassSingleton.getInstance();
        System.out.println(singleton1);
        System.out.println(singleton2);
        System.out.println(singleton1 == singleton2);
    }
}
