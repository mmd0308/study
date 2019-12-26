package com.hzqing.thread.pool.demo2;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author hzqing
 * @date 2019-09-17 10:29
 */
@SuppressWarnings("all")
public class Demo implements Runnable{
    static long start = 0;
    public static void main(String[] args) {
        ScheduledExecutorService service = null;
        try {
            service = new ScheduledThreadPoolExecutor(1);
            start = System.currentTimeMillis();
            service.schedule(new Demo(),5, TimeUnit.SECONDS);
        }finally {
            if (service != null) service.shutdown();
        }
    }

    public void run() {
        try {
            System.out.println("任务执行前间隔时间：" + (System.currentTimeMillis()-start));
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Demo3.run");
        System.out.println("执行完毕花销时间：" + (System.currentTimeMillis()-start));
    }
}
