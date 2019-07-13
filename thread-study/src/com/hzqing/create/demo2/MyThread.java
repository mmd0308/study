package com.hzqing.create.demo2;

/**
 * @author hzqing
 * @date 2019-07-13 10:50
 */
public class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println("当前是： " + Thread.currentThread().getName() + " 线程运行！");
    }
}
