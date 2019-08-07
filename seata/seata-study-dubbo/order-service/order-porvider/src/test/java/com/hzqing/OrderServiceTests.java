package com.hzqing;

import com.hzqing.order.IOrderService;
import com.hzqing.pay.IPayService;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hzqing
 * @date 2019-08-05 22:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTests {

    @Autowired
    private IOrderService orderService;

    @Test
    public void test(){
        orderService.add(30);
    }
}
