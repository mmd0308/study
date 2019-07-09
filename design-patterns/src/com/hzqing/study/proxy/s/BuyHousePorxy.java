package com.hzqing.study.proxy.s;

/**
 * @author hzqing
 * @date 2019-07-03 08:24
 */
public class BuyHousePorxy implements BuyHouse{

    private BuyHouse buyHouse;

    public BuyHousePorxy(BuyHouse buyHouse) {
        this.buyHouse = buyHouse;
    }


    @Override
    public void buyHouse() {
        before();
        buyHouse.buyHouse();
        after();
    }

    private void after() {
        System.out.println("购房结束");
    }

    private void before() {
        System.out.println("我是购房代理商,我这里有很多房源...");
    }
}
