package com.hzqing.study.singleton;

/**
 * 单例设计模式：
 *  饿汉式
 *      调用效率高
 *      线程安全
 *      不能延迟加载
 * @author hzqing
 * @date 2019-06-28 15:12
 */
public class HungrySingleton {
    // 私有化构造方法
    private HungrySingleton() {
    }

    // 类初始化的时候，实例化一个对象
    private static HungrySingleton INSTANCT = new HungrySingleton();

    // 向外暴露一个公共访问点
    public static HungrySingleton getInstance(){
        return INSTANCT;
    }
}
