package com.hzqing.study.observer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hzqing
 * @date 2019-07-09 07:52
 */
public class Subject {
    private String name;
    /**
     * 存储所有的观察者
     */
    private Set<Observer> observerSet = new HashSet<>();

    public void setName(String name) {
        this.name = name;
        // 通知所有观察者
        this.notifyAllObserver();
    }

    /**
     * 添加观察者
     * @param observer
     */
    public void addOberver(Observer observer){
        observerSet.add(observer);
    }

    /**
     * 通知所有的观察者
     */
    private void notifyAllObserver(){
        observerSet.forEach(itme -> {
           itme.update();
        });
    }
}
