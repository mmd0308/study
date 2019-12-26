package com.hzqing.thread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @author hzqing
 * @date 2019-12-26 16:11
 */
public class ThreadFinish extends Thread{

    /**
     * 线程终止标记
     */
    private static volatile boolean isFinish = false;

    /**
     * 修改终止标记，终止线程
     */
    public void shutdown(){
        isFinish = true;
    }

    @Override
    public void run() {
        // 只有满足退出要求，线程执行完毕
        while (!isFinish){
           // 处理业务代码
            System.out.println("---执行业务代码---");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadFinish threadFinish = new ThreadFinish();
        // 启动线程
        threadFinish.start();
        // 线程睡眠100毫秒
        TimeUnit.MILLISECONDS.sleep(100);
        // 终止线程
        threadFinish.shutdown();
    }
}
