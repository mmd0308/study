package com.hzqing.study.factorymethod;

/**
 * 宝马车辆生产工厂
 * @author hzqing
 * @date 2019-06-30 09:19
 */
public class BmwCarFactory implements CarFactory {
    /**
     * 生产宝马车
     * @return
     */
    @Override
    public Car produceCar() {
        return new BmwCar();
    }
}
