package com.hzqing.sync.demo4;


import com.hzqing.sync.demo2.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author hzqing
 * @date 2019-07-14 11:09
 */
public class Test2 {
    static int  count = 1;

    public static void add(){
        synchronized (Test2.class){
            count++;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<1000;i++){
            new Thread(() ->{
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Test2.add();
            }).start();
        }
        for(int i=0;i<1000;i++){
            new Thread(() ->{
                try {
                    TimeUnit.MILLISECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Test2.add();
            }).start();
        }
        TimeUnit.SECONDS.sleep(3);
        System.out.println("最终结果是：" +  Test2.count);
    }
}
