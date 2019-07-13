package com.hzqing.create.demo2;

/**
 * @author hzqing
 * @date 2019-07-13 10:51
 */
public class Test{
    public static void main(String[] args) {
       Thread thread1 = new Thread(new MyThread(),"HZQ-RUNNABLE-THREAD");
       thread1.start();
    }
}
