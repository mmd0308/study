package com.hzqing.study.simplefactory;

/**
 * 奥迪汽车生产
 * @author hzqing
 * @date 2019-06-29 09:40
 */
public class AudiCar implements Car {
    @Override
    public void run() {
        System.out.println("奥迪汽车启动...");
    }
}
