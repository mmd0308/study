package com.hzqing.order;

import com.hzqing.pay.IPayService;
import org.apache.dubbo.config.annotation.Reference;

/**
 * @author hzqing
 * @date 2019-08-05 22:18
 */
public class OrderServiceImpl implements IOrderService {


    @Reference
    private IPayService payService;

    @Override
    public String add(String orderId) {

        return "新增订单";
    }
}
