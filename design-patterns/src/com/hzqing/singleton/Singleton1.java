package com.hzqing.singleton;

/**
 * 单例设计模式：
 *  饿汉式
 *      调用效率高
 *      线程安全
 *      不能延迟加载
 * @author hzqing
 * @date 2019-06-28 15:12
 */
public class Singleton1 {
    // 私有化构造方法
    private Singleton1() {
    }

    // 类初始化的时候，实例化一个对象
    private static  Singleton1 singleton1 = new Singleton1();

    // 向外暴露一个公共访问点
    public static Singleton1 getInstance(){
        return singleton1;
    }
}
