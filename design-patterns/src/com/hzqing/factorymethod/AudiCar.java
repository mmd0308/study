package com.hzqing.factorymethod;

/**
 * @author hzqing
 * @date 2019-06-30 09:17
 */
public class AudiCar implements Car {
    @Override
    public void run() {
        System.out.println("奥迪车启动");
    }
}
