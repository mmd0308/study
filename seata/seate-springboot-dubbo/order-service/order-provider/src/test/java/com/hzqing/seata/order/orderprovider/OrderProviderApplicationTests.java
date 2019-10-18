package com.hzqing.seata.order.orderprovider;

import com.hzqing.seata.order.api.IOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderProviderApplicationTests {

    @Autowired
    private IOrderService orderService;

    @Test
    public void contextLoads() {
        orderService.create(10);
    }

}
