package com.hzqing.singleton;

/**
 * @author hzqing
 * @date 2019-07-01 10:25
 */
public class EnumTest {
    public static void main(String[] args) {
        EnumSingleton singleton1 = EnumSingleton.INSTANCT;
        EnumSingleton singleton2 = EnumSingleton.INSTANCT;

        System.out.println(singleton1);
        System.out.println(singleton2);
        System.out.println(singleton1 == singleton2);
    }
}
