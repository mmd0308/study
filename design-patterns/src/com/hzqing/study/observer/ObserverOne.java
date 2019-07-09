package com.hzqing.study.observer;

/**
 * @author hzqing
 * @date 2019-07-09 08:01
 */
public class ObserverOne implements Observer {
    @Override
    public void update() {
        System.out.println("ObserverOne 收到通知" );
    }
}
