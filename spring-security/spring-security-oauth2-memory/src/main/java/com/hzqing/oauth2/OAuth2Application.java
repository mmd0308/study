package com.hzqing.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author hzqing
 * @date 2019-08-05 14:21
 */
@SpringBootApplication
public class OAuth2Application {
    public static void main(String[] args) {
        SpringApplication.run(OAuth2Application.class,args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
