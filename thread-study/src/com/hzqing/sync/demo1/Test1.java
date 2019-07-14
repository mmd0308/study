package com.hzqing.sync.demo1;

import java.util.concurrent.TimeUnit;

/**
 * @author hzqing
 * @date 2019-07-14 09:48
 */
public class Test1 {
    static int count = 1;
    public static void incr(){
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i=0;i<1000;i++){
            new Thread(() -> incr()).start();
        }
        TimeUnit.SECONDS.sleep(2);
        System.out.println(count);
    }
}
