package com.hzqing.thread.pool.demo3;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author hzqing
 * @date 2019-09-17 11:00
 */
@SuppressWarnings("all")
public class Demo implements Runnable{

    static long start = 0;

    public static void main(String[] args) {
        ScheduledExecutorService service = null;
        try {
            service = Executors.newScheduledThreadPool(1);
            start = System.currentTimeMillis();
            System.out.println(start);
            service.scheduleAtFixedRate(new Demo(),0,10, TimeUnit.SECONDS);
        }finally {
            if (service != null) service.shutdown();
        }

    }

    public void run() {
        try {
            System.out.println("任务调度前等待时间：" + (System.currentTimeMillis() - start));
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Demo.run");
        System.out.println("任务调度完成时间：" + (System.currentTimeMillis() - start));
    }
}
