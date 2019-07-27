package com.hzqing.client;

import com.hzqing.api.IHelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hzqing
 * @date 2019-07-26 21:09
 */
@RestController
public class HelloContoller {

    @Reference
    private IHelloService helloService;

    @GetMapping("/hello")
    public String hello(){
        return helloService.sayHello();
    }
}
