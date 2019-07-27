package com.hzqing.client;

import com.hzqing.api.IHelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hzqing
 * @date 2019-07-26 21:32
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloTest {

    @Reference
    private IHelloService helloService;

    @Test
    public void hello(){
        for (int i = 0; i < 10; i++){
            String res = helloService.sayHello();
            System.out.println(res);

        }
    }
}
