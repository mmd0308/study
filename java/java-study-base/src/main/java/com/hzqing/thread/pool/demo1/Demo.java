package com.hzqing.thread.pool.demo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hzqing
 * @date 2019-09-16 13:52
 */
@SuppressWarnings("all")
public class Demo implements Runnable {

    public static void main(String[] args) {
        // 创建一个固定为5个线程的线程池
        ExecutorService service = Executors.newFixedThreadPool(5);
        try {
            for (int i = 0; i < 10; i++) {
                // 提交任务
                service.submit(new Demo());
            }
        }finally {
            service.shutdown();
        }

    }
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
