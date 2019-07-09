package com.hzqing.study.strategy;

/**
 * @author hzqing
 * @date 2019-07-04 08:23
 */
public class AliPay extends PayMent{
    @Override
    public String getName() {
        return "支付宝支付";
    }

    @Override
    public double queryBalance(String key) {
        return 300;
    }
}
