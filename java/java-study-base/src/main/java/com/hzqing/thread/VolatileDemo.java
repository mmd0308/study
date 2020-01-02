package com.hzqing.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author hzqing
 * @date 2019-12-27 14:37
 */
public class VolatileDemo {

    private volatile static boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (!stop){
                i++;
            }
        });
        thread.start();
        // 主线程睡眠2秒
        TimeUnit.SECONDS.sleep(2);
        stop = true;
    }
}
