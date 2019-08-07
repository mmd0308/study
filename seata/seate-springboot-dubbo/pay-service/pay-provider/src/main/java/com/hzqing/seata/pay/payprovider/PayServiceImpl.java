package com.hzqing.seata.service.impl;

import com.hzqing.seata.service.IPayServcie;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author hzqing
 * @date 2019-08-06 20:06
 */
@Service
public class PayServiceImpl implements IPayServcie {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void Pay(int num) {
        jdbcTemplate.execute("insert into db_seata (msg) values ('调用支付接口，支付："+ num +" 元')");
    }
}
