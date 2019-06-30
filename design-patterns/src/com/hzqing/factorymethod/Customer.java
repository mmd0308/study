package com.hzqing.factorymethod;

/**
 * @author hzqing
 * @date 2019-06-30 09:20
 */
public class Customer {
    public static void main(String[] args) {

        // 客户需要一辆宝马
        CarFactory factory = new BmwCarFactory();
        Car car = factory.produceCar();
        car.run();

        // 客户还需要一辆奥迪
        CarFactory  audiFactory = new AudiCarFactory();
        Car audi = audiFactory.produceCar();
        audi.run();

        // 客户新需要一辆奔驰车
        CarFactory benzFactory = new BenzCarFactory();
        Car benz = benzFactory.produceCar();
        benz.run();
    }
}
