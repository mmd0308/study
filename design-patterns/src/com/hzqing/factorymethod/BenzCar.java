package com.hzqing.factorymethod;

/**
 * @author hzqing
 * @date 2019-06-30 09:28
 */
public class BenzCar implements Car{

    @Override
    public void run() {
        System.out.println("奔驰车启动");
    }
}
