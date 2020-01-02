package com.hzqing.thread.demo1;

/**
 * @author hzqing
 * @date 2020-01-02 08:26
 */
public class Test2 extends Thread{
    // 获取实例对象锁
    public synchronized void demo1(){
        demo2();
    }

    private void demo2() {
        // 获取实例对象锁
        synchronized (this){

        }
    }

    @Override
    public void run() {
        demo1();
    }
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.start();
    }
}
