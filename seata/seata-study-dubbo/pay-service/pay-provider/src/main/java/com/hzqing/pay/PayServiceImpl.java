package com.hzqing.pay;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author hzqing
 * @date 2019-08-05 22:06
 */
@Service
public class PayServiceImpl implements IPayService {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String pay(String num) {
        jdbcTemplate.execute("insert into db_seata (msg) values ('调用支付接口,支付：" + num+ " 元')");
        return "支付：" + num;
    }
}
