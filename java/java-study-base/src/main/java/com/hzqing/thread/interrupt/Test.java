package com.hzqing.thread.interrupt;

import java.util.concurrent.TimeUnit;

public class Test {

    static int i = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()){ // 默认是false
                i++;
                System.out.println(Thread.currentThread().getName() + " 线程运行中");
            }
            System.out.println("i = " + i);
        }, "HZQ-THREAD-INTERRCUPT");
        thread.start();
        // 线程睡眠100毫秒
        TimeUnit.MILLISECONDS.sleep(100);
        // 终止线程
        thread.interrupt();
    }
}