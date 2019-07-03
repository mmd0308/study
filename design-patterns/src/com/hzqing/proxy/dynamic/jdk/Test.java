package com.hzqing.proxy.dynamic.jdk;

/**
 * @author hzqing
 * @date 2019-07-03 08:47
 */
public class Test {
    public static void main(String[] args) {
        BuyHouse buyHouse = (BuyHouse) new BuyHouseJdkProxy().getInstance(new BuyHouseImpl());
        buyHouse.buyHouse();
    }
}
