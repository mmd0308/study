package com.hzqing.study.singleton;

/**
 * 单例模式：
 *      静态内部类：
 *          调用效率高
 *          可以延迟加载
 *          线程安全
 *
 * @author hzqing
 * @date 2019-06-28 15:20
 */
public class StaticInnerClassSingleton {
    // 私有化构造方法
    private StaticInnerClassSingleton(){

    }
    // 使用匿名内部，初始化实例
    private static class innerClass{
        private static StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    // 对外提供公共的访问点
    public static StaticInnerClassSingleton getInstance(){
        return innerClass.INSTANCE;
    }
}
