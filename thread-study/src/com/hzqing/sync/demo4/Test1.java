package com.hzqing.sync.demo4;


import java.util.concurrent.TimeUnit;

/**
 * @author hzqing
 * @date 2019-07-14 11:02
 */
public class Test1 {
   int count = 1;

    public void add(){
        synchronized (this){
            count++;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Test1 test = new Test1();
        Test1 test1 = new Test1();

        for (int i=0;i<1000;i++){
            new Thread(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test.add();
            }).start();
        }
        for (int i=0;i<1000;i++){
            new Thread(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test1.add();
            }).start();
        }
        TimeUnit.SECONDS.sleep(3);
        System.out.println(test.count);
        System.out.println(test1.count);
    }
}
