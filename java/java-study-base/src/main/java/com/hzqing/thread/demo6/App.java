package com.hzqing.thread.demo6;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author hzqing
 * @date 2020-01-03 10:54
 */
@SuppressWarnings("all")
public class App {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5); // 只有5个令牌，5个线程可以同时访问

        for (int i = 1; i <= 10; i++) {
            new Car(i,semaphore).start();
        }
    }

    static class Car extends Thread{
        private int num;

        private Semaphore semaphore;

        public Car(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire(); // 获取令牌，如果获取不到，就会被阻塞
                System.out.println("第" + num + "个车，获得一个车位！");
                TimeUnit.SECONDS.sleep(3); // 停车3秒
                System.out.println("第" + num + "个车，开走啦！");
                semaphore.release(); // 释放令牌，表示有空的停车位了
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
