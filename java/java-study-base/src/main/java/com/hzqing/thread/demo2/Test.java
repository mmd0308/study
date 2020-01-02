package com.hzqing.thread.demo2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hzqing
 * @date 2020-01-02 08:46
 */
public class Test {

    static Lock lock = new ReentrantLock();
    static int i  = 0;

    static void incr(){
        // 获取锁
        lock.lock();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i++;
        // 释放锁
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        for (int j = 0; j < 100; j++) {
            new Thread(() -> {
               Test.incr();
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(i);
    }
}
