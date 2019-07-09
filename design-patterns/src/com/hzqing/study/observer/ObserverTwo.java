package com.hzqing.study.observer;

/**
 * @author hzqing
 * @date 2019-07-09 08:02
 */
public class ObserverTwo implements Observer {

    @Override
    public void update() {
        System.out.println("ObserverTwo 收到通知");
    }
}
