package com.hzqing.thread.demo3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author hzqing
 * @date 2020-01-03 08:27
 */
public class ConditionWait implements Runnable {

    private Lock lock;
    private Condition condition;

    public ConditionWait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {

        try {
            lock.lock();
            System.out.println("begin --- ConditionWait.run");
            condition.await(); // 等待阻塞
            System.out.println("end --- ConditionWait.run");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
