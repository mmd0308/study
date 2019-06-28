package com.hzqing.singleton;

/**
 * 单例模式
 *  双重锁模式
 * @author hzqing
 * @date 2019-06-28 15:18
 */
public class Singleton3{

    // 私有化构造方法
    private Singleton3(){

    }

    private static Singleton3 singleton3 = null;

    // 对外提供公共的访问点
    public static Singleton3 getInstance(){
        if (singleton3 == null){
            synchronized (Singleton3.class){
                if (singleton3 == null){
                    singleton3 = new Singleton3();
                }
            }
        }
        return singleton3;
    }

}
