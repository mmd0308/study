package com.hzqing.sync.demo2;

import java.util.concurrent.TimeUnit;

/**
 * @author hzqing
 * @date 2019-07-14 10:17
 */
public class Test {
     int count = 1;

    public synchronized int add(){
        System.out.println(this);
        return ++count;
    }
    public static void main(String[] args) throws InterruptedException {

        Test test = new Test();
        Test test1 = new Test();

        for (int i=0; i<1000; i++){
            new Thread(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test.add();
                test1.add();
            }).start();
        }
        TimeUnit.SECONDS.sleep(2);
        System.out.println("test对象的结果： " + test.count);


        TimeUnit.SECONDS.sleep(1);
        System.out.println("test1对象的结果：" + test1.count);
    }
}
