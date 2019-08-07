package com.hzqing.seata.hzqorder.controller;


import com.hzqing.seata.hzqorder.entity.Order;
import com.hzqing.seata.hzqorder.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-08-07
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;


    @PostMapping("add")
    public void pay(@RequestBody Order order){
        order.setCreateTime(LocalDateTime.now());
        orderService.save(order);
    }

}
