package com.hzqing.seata.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HzqEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HzqEurekaApplication.class, args);
    }

}
