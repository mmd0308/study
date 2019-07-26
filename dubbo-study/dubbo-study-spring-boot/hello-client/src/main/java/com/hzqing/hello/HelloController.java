package com.hzqing.hello;

import com.hzqing.IHelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hzqing
 * @date 2019-07-26 16:25
 */
@RestController
public class HelloController {

    @Reference
    private IHelloService helloService;

    @GetMapping("/hello")
    public String hello(){
        return helloService.sayHello();
    }

}

