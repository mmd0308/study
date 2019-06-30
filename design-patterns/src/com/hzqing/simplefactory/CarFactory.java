package com.hzqing.simplefactory;

/**
 * 生产汽车的工厂
 * @author hzqing
 * @date 2019-06-29 09:42
 */
public class CarFactory {

    /**
     * 根据客户需要的车型，生产对应的汽车
     * @param carname
     * @return
     */
    public static Car produceCar(String carname){
        Car car = null;
        if (carname.equals("AUDI")){
            car = new AudiCar();
        }else  if (carname.equals("BMW")){
            car = new BmwCar();
        } else if (carname.equals("BENZ")){
            car = new BenzCar();
        }
        else  {
            throw new RuntimeException("你要的车，本工厂不能生产");
        }
        return  car;
    }
}
