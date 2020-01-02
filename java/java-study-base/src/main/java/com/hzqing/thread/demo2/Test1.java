package com.hzqing.thread.demo2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author hzqing
 * @date 2020-01-02 09:02
 */
public class Test1 {

    static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    // 定义写锁
    static Lock wlock = readWriteLock.writeLock();
    // 定义读锁
    static Lock rlock = readWriteLock.readLock();

    static Map<String,String> cacheMap = new HashMap<>();

    public static String get(String key){
        // 获取读锁
        rlock.lock();
        try{
            return cacheMap.get(key);
        }finally {
            // 释放读锁
            rlock.unlock();
        }
    }

    public static void put(String key,String val){
        // 获取写锁
        wlock.lock();
        try {
            cacheMap.put(key,val);
        }finally {
            // 释放写锁
            wlock.unlock();
        }
    }
}
