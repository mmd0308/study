package com.hzqing.singletonserializable;

import java.io.Serializable;

/**
 * @author hzqing
 * @date 2019-07-01 13:09
 */
public class LazySingleton implements Serializable {

    private LazySingleton(){}

    private static LazySingleton INSTANCE = null;

    public static synchronized LazySingleton getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }

    private Object readResolve(){
        return INSTANCE;
    }
}
