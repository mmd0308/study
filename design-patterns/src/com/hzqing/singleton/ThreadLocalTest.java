package com.hzqing.singleton;

/**
 * @author hzqing
 * @date 2019-07-01 12:18
 */
public class ThreadLocalTest {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + " : " + ThreadLocalSingleton.getInstance());
        System.out.println(Thread.currentThread().getName() + " : " + ThreadLocalSingleton.getInstance());
        System.out.println(Thread.currentThread().getName() + " : " + ThreadLocalSingleton.getInstance());

        new Thread(() ->  {
                for (int i=0 ;i<3;i++){
                    System.out.println(Thread.currentThread().getName() + " : " + ThreadLocalSingleton.getInstance());
                }
            }
        ).run();

        new Thread(() -> {
                for (int i=0 ;i<3;i++){
                    System.out.println(Thread.currentThread().getName() + " : " + ThreadLocalSingleton.getInstance());
                }
            }
        ).start();
    }
}
