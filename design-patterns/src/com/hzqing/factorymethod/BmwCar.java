package com.hzqing.factorymethod;

/**
 * 宝马车类
 * @author hzqing
 * @date 2019-06-30 09:16
 */
public class BmwCar implements Car{

    @Override
    public void run() {
        System.out.println("宝马车启动");
    }
}
