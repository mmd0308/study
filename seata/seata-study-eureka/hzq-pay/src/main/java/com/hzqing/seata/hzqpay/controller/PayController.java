package com.hzqing.seata.hzqpay.controller;


import com.hzqing.seata.hzqpay.entity.Pay;
import com.hzqing.seata.hzqpay.service.IPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private IPayService payService;


    @PostMapping("add")
    public void pay(@RequestBody Pay pay){
        pay.setCreateTime(LocalDateTime.now());
        payService.save(pay);
    }
}
