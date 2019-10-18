package com.hzqing.seata.order.orderprovider;

import com.hzqing.seata.order.api.IOrderService;
import com.hzqing.seata.pay.IPayServcie;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hzqing
 * @date 2019-08-06 20:13
 */
@Service
public class OrderServiceImpl implements IOrderService {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Reference
    IPayServcie payServcie;

    @Override
   // @Transactional
    @GlobalTransactional(timeoutMills = 300000, name = "dubbo-gts-order")
    public void create(int num) {
        jdbcTemplate.execute("insert into db_seata (msg) values ('生成订单，订单id是："+ num +" ')");
        payServcie.Pay(num);
        System.out.println(1/0);
    }
}
