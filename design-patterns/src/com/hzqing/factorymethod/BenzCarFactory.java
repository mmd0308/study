package com.hzqing.factorymethod;

/**
 * @author hzqing
 * @date 2019-06-30 09:29
 */
public class BenzCarFactory implements CarFactory {

    /**
     * 生产奔驰车
     * @return
     */
    @Override
    public Car produceCar() {
        return new BenzCar();
    }
}
