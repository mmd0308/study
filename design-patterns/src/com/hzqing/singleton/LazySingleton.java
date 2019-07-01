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
public class LazySingleton {

    // 私有化构造方法
    private LazySingleton(){}

    // 声明一个变量
    private static LazySingleton INSTANCE = null;

    // 对外暴露公共访问点
    public synchronized static LazySingleton getInstance(){
        if (INSTANCE == null){
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }

}
