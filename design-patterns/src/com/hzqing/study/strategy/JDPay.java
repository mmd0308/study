package com.hzqing.study.strategy;

/**
 * @author hzqing
 * @date 2019-07-04 08:34
 */
public class JDPay extends PayMent {
    @Override
    public String getName() {
        return "京东支付";
    }

    @Override
    public double queryBalance(String key) {
        return 633.5;
    }
}
