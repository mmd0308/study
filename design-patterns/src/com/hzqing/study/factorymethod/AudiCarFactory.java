package com.hzqing.study.factorymethod;

/**
 * 奥迪车生产工厂
 * @author hzqing
 * @date 2019-06-30 09:18
 */
public class AudiCarFactory implements CarFactory {
    /**
     * 生产奥迪
     * @return
     */
    @Override
    public Car produceCar() {
        return new AudiCar();
    }
}
