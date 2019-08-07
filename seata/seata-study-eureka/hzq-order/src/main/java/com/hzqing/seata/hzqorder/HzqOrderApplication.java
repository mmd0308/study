package com.hzqing.seata.hzqorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@MapperScan(basePackages = "com.hzqing.seata.hzqorder.mapper")
public class HzqOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(HzqOrderApplication.class, args);
    }



    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }


}
