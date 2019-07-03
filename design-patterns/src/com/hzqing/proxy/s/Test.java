package com.hzqing.proxy.s;

/**
 * @author hzqing
 * @date 2019-07-03 08:29
 */
public class Test {
    public static void main(String[] args) {
        BuyHouse buyHouse = new BuyHousePorxy(new BuyHouseImpl());
        buyHouse.buyHouse();
    }
}
