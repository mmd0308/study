package com.hzqing.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hzqing
 * @date 2019-07-04 08:30
 */
public class PayStrategy {

    private static Map<String,PayMent> payMentMap = new HashMap<>();

    static {
        payMentMap.put(Constant.ALI_PAY,new AliPay());
        payMentMap.put(Constant.JD_PAY,new JDPay() );
        payMentMap.put(Constant.WECHAT_PAY,new WeChatPay());
    }

    public static PayMent get(String key){
        return payMentMap.get(key);
    }


}
