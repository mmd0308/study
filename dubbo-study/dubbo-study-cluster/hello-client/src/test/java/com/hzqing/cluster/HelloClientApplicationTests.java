package com.hzqing.cluster;

import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloClientApplicationTests {

    @Reference(cluster = "failsafe")
    private IHelloService helloService;

    @Test
    public void contextLoads() {
        String sayHello = helloService.SayHello();
        System.out.println(sayHello);
    }

}
