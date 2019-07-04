package com.hzqing.strategy;

/**
 * @author hzqing
 * @date 2019-07-04 08:23
 */
public class WeChatPay extends PayMent {
    @Override
    public String getName() {
        return "微信支付";
    }

    @Override
    public double queryBalance(String key) {
        return 300;
    }
}
