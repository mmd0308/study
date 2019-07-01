package com.hzqing.singletonreflex;

import java.lang.reflect.Constructor;

/**
 * @author hzqing
 * @date 2019-07-01 12:50
 */
public class ReflexTest {

    public static void main(String[] args) throws Exception {
        HungrySingleton singleton1 = HungrySingleton.getInstance();

        // 使用反射创建对象
        Class<HungrySingleton> singletonClass = HungrySingleton.class;
        Constructor<HungrySingleton> constructor = singletonClass.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        HungrySingleton singleton2 = constructor.newInstance();

        System.out.println(singleton1);
        System.out.println(singleton2);
        System.out.println(singleton1 == singleton2);

    }
}
