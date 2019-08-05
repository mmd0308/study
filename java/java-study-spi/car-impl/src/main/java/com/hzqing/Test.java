package com.hzqing;

import com.sun.tools.javac.util.ServiceLoader;

/**
 * @author hzqing
 * @date 2019-08-05 18:33
 */
public class Test {
    public static void main(String[] args) {
        ServiceLoader<Car> cars = ServiceLoader.load(Car.class);
        cars.forEach(car -> {
            System.out.println(car.run());
        });
    }

}
