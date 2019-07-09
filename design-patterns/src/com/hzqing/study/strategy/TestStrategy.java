package com.hzqing.study.strategy;

/**
 * @author hzqing
 * @date 2019-07-04 08:36
 */
public class TestStrategy {
    public static void main(String[] args) {
        String key = "JD_PAY";

        PayMent payMent = PayStrategy.get(key);
        PayRestult pay = payMent.pay(key, 20.0);
        System.out.println(pay);
    }
}
