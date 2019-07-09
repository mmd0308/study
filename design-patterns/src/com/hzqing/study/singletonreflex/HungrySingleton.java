package com.hzqing.study.singletonreflex;

/**
 * @author hzqing
 * @date 2019-07-01 12:47
 */
public class HungrySingleton {
    private HungrySingleton(){
        // 如果对象已经存在，直接抛出异常
        if (INSTANCE != null){
            throw new RuntimeException("该对象已经被创建，不允许再次创建");
        }
    }
    private static HungrySingleton INSTANCE = new HungrySingleton();

    public static HungrySingleton getInstance(){
        return INSTANCE;
    }
}
