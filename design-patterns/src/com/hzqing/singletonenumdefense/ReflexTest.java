package com.hzqing.singletonenumdefense;

import java.lang.reflect.Constructor;

/**
 * @author www.hzqing.com
 * @date 2019-07-02 07:56
 */
public class ReflexTest {

    public static void main(String[] args) throws Exception {
        EnumSingleton singleton1 = EnumSingleton.INSTANCE;
//
//        Class<EnumSingleton> singletonClass = EnumSingleton.class;
//        Constructor<EnumSingleton> constructor = singletonClass.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        EnumSingleton singleton2 = constructor.newInstance();
//
//        System.out.println(singleton1);
//        System.out.println(singleton2);
//        System.out.println(singleton1 == singleton2);


        Class<EnumSingleton> enumSingletonClass = EnumSingleton.class;
        Constructor<EnumSingleton> declaredConstructor = enumSingletonClass.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        EnumSingleton singleton3 = declaredConstructor.newInstance("INSTANCE", 0);

        System.out.println(singleton1);
        System.out.println(singleton3);

    }
}
