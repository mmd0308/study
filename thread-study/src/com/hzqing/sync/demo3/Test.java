package com.hzqing.sync.demo3;

import java.util.concurrent.TimeUnit;

/**
 * @author hzqing
 * @date 2019-07-14 10:56
 */
public class Test {

    static int count = 1;
    public synchronized static void add(){
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i=0; i<1000; i++){
            new Thread(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Test.add();
            }).start();
        }
        TimeUnit.SECONDS.sleep(2);
        System.out.println(count);
    }
}
