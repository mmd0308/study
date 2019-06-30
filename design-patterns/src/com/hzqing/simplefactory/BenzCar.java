package com.hzqing.simplefactory;

/**
 * 生产奔驰汽车
 * @author hzqing
 * @date 2019-06-29 09:58
 */
public class BenzCar implements Car {
    @Override
    public void run() {
        System.out.println("奔驰汽车启动....");
    }
}
