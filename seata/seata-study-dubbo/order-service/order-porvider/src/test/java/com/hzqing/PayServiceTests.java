package com.hzqing;

import com.hzqing.pay.IPayService;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hzqing
 * @date 2019-08-05 22:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PayServiceTests {

    @Reference
    private IPayService payService;

    @Test
    public void test(){
        String pay = payService.pay("订单调用");
        System.out.println(pay);
    }
}
