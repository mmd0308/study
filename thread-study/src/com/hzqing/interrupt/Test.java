package com.hzqing.interrupt;


import java.util.concurrent.TimeUnit;

/**
 * @author hzqing
 * @date 2019-07-13 11:52
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()){ // 默认是false
                try {
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + " 线程运行中");
                } catch (InterruptedException e) {
                    // 收到中断消息之后，进行中断
                    break;
                }
            }
        }, "HZQ-THREAD-INTERRCUPT");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }
}
