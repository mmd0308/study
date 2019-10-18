package com.hzqing.seata.order.orderprovider.controller;

import com.hzqing.seata.order.api.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hzqing
 * @date 2019-08-06 22:36
 */
@RestController
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping("/order/{num}")
    public String create(@PathVariable int num){
        orderService.create(num);
        return "调用创建订单";
    }
}
