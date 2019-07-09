package com.hzqing.study.strategy;

/**
 * @author hzqing
 * @date 2019-07-04 08:25
 */
public class Test {
    public static void main(String[] args) {
        String key = "WECHAT_PAY";
        PayMent payMent = null;

        if (key.equals(Constant.ALI_PAY)){
            payMent= new AliPay();
            PayRestult pay = payMent.pay(key, 2000.0);
            System.out.println(pay);
        } else if (key.equals(Constant.WECHAT_PAY)){
            payMent = new WeChatPay();
            PayRestult pay = payMent.pay(key, 30.0);
            System.out.println(pay);
        } else {
            payMent = new JDPay();
            PayRestult pay = payMent.pay(key, 30.0);
            System.out.println(pay);
        }
    }
}
