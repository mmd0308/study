package com.hzqing.thread.demo5;

import java.util.concurrent.CountDownLatch;

/**
 * @author hzqing
 * @date 2020-01-03 10:05
 */
public class App extends Thread{

    static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        // 模型并发1000个线程
        for (int i = 0; i < 1000; i++) {
            new App().start();
        }
        // 当所有的线程进入等待状态后，一起并发执行
        countDownLatch.countDown();
    }

    @Override
    public void run() {
        try {
            // 阻塞等待，等待所有线程就绪后，一起执行
            countDownLatch.await();
            // TODO 需要执行的业务代码
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
