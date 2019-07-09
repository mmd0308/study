package com.hzqing.study.strategy;

public abstract class PayMent {
    /**
     * 获取使用的支付方式名称
     * @return
     */
    public abstract String getName();

    /**
     * 查询余额
     * @param key
     * @return
     */
    public abstract double queryBalance(String key);

    /**
     * 支付
     * @param key
     * @param amount
     * @return
     */
    public  PayRestult pay(String key,Double amount){
        if (queryBalance(key) < amount ){
            return new PayRestult(key,"支付失败","余额不足！");
        }

        return new PayRestult(key,"支付成功","支付金额是:" + amount);
    }

}
