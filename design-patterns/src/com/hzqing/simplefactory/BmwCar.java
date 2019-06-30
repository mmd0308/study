package com.hzqing.simplefactory;

/**
 * 生产宝马车的类
 * @author hzqing
 * @date 2019-06-29 09:41
 */
public class BmwCar implements Car {
    @Override
    public void run() {
        System.out.println("宝马汽车启动....");
    }
}
