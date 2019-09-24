package com.hzqing.jvm.demo2;

/**
 * @author hzqing
 * @date 2019-09-24 15:37
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = new HzqClassLoader();
        Class<?> clazz = classLoader.loadClass("com.hzqing.jvm.demo2.Demo");
        System.out.println(classLoader);
        System.out.println(clazz.getClassLoader());
        Object object = clazz.newInstance();
        System.out.println(object.getClass().getClassLoader());
    }
}
