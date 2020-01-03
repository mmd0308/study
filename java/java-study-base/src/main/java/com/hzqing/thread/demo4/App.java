package com.hzqing.thread.demo4;

import java.util.concurrent.CountDownLatch;

/**
 * @author hzqing
 * @date 2020-01-03 10:01
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" 正在执行");
            countDownLatch.countDown(); // 3-1 = 2
        },"thread-1").start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" 正在执行");
            countDownLatch.countDown(); // 2-1 = 1
        },"thread-2").start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" 正在执行");
            countDownLatch.countDown(); // 1-1 = 0
        },"thread-3").start();

        countDownLatch.await(); // 一直阻塞，直到countDown倒数为0时
    }
}
