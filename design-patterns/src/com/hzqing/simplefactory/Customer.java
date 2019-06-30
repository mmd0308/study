package com.hzqing.simplefactory;

/**
 * 客户类
 * @author hzqing
 * @date 2019-06-29 09:47
 */
public class Customer {

    public static void main(String[] args) {

        // 客户需要一辆宝马
        Car bwm = CarFactory.produceCar("BMW");
        bwm.run();

        // 客户需要一辆奔驰
        Car benz = CarFactory.produceCar("BENZ");
        benz.run();

    }
}
