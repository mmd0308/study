package com.hzqing.study.singleton;

/**
 * 单例模式
 *  双重锁模式
 * @author hzqing
 * @date 2019-06-28 15:18
 */
public class DoubleCheckSingleton {

    // 私有化构造方法
    private DoubleCheckSingleton(){

    }

    private static DoubleCheckSingleton INSTANCE = null;

    // 对外提供公共的访问点
    public static DoubleCheckSingleton getInstance(){
        if (INSTANCE == null){
            synchronized (DoubleCheckSingleton.class){
                if (INSTANCE == null){
                    INSTANCE = new DoubleCheckSingleton();
                }
            }
        }
        return INSTANCE;
    }

}
