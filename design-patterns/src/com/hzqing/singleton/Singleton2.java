package com.hzqing.singleton;

/**
 * 单例模式
 *    懒汉式
 *         效率不高
 *         线程安全
 *         可以延迟加载
 * @author hzqing
 * @date 2019-06-28 15:15
 */
public class Singleton2 {

    // 私有化构造方法
    private  Singleton2(){}

    // 声明一个变量
    private static Singleton2 singleton2 = null;

    // 对外暴露公共访问点
    public synchronized static Singleton2 getInstance(){
        if (singleton2 == null){
            singleton2 = new Singleton2();
        }
        return singleton2;
    }

}
