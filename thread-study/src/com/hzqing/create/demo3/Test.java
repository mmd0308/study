package com.hzqing.create.demo3;

import java.util.concurrent.*;

/**
 * @author hzqing
 * @date 2019-07-13 11:09
 */
public class Test {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = new ScheduledThreadPoolExecutor(1);
        Future<String> future = executorService.submit(new CallableThread());
        String s = future.get();
        System.out.println(s);
        executorService.shutdown();
    }
}
