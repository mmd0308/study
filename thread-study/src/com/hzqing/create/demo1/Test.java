package com.hzqing.create.demo1;

/**
 * @author hzqing
 * @date 2019-07-13 10:41
 */
public class Test {
    public static void main(String[] args) {
       ExtentThread thread1 = new ExtentThread();
       thread1.setName("HZQ-TEST-THREAD1");
       thread1.start();
       ExtentThread thread2 = new ExtentThread();
       thread2.setName("HZQ-TEST-THREAD2");
       thread2.start();
    }
}
