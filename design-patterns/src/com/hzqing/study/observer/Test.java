package com.hzqing.study.observer;

/**
 * @author hzqing
 * @date 2019-07-09 08:03
 */
public class Test {
    public static void main(String[] args) {
        Subject subject = new Subject();
        // 被观察者添加观察者
        subject.addOberver(new ObserverOne());
        subject.addOberver(new ObserverTwo());
        subject.setName("张三");
    }
}
