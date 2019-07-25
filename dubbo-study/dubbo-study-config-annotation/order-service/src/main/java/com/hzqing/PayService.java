package com.hzqing;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * @author hzqing
 * @date 2019-07-25 11:07
 */
@Component("payService")
public class PayService  {

    @Reference
    private IPayService payService;

    public String toPay(String info) {
        return payService.pay(info);
    }
}
