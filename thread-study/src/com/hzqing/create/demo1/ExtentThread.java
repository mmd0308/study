package com.hzqing.create.demo1;

/**
 * @author hzqing
 * @date 2019-07-13 10:40
 */
public class ExtentThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 运行！");
    }
}
