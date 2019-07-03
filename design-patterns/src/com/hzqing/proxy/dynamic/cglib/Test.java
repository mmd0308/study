package com.hzqing.proxy.dynamic.cglib;

/**
 * @author hzqing
 * @date 2019-07-03 08:47
 */
public class Test {
    public static void main(String[] args) {
        BuyHouseImpl buyHouse = (BuyHouseImpl) new BuyHouseCglibProxy().getInstance(BuyHouseImpl.class);
        buyHouse.buyHouse();
    }
}
