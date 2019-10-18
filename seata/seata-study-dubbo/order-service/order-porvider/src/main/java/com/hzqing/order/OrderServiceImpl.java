package com.hzqing.order;

import com.hzqing.pay.IPayService;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hzqing
 * @date 2019-08-05 22:18
 */
@Service
public class OrderServiceImpl implements IOrderService {


    @Reference
    private IPayService payService;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    @GlobalTransactional(timeoutMills = 300000, name = "dubbo-demo-tx")
    //@Transactional
    public String add(int orderId) {
        jdbcTemplate.execute("insert into db_seata (msg) values ('新增订单,订单id是："+orderId+"')");
        payService.pay( orderId * 2 + "");
        // 出现异常
        System.out.println(1/0);
        return "新增订单";
    }
}
