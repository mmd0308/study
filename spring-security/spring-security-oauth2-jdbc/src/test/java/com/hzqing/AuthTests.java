package com.hzqing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hzqing
 * @date 2019-08-06 08:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthTests {

    @Test
    public void test(){
        System.out.println(new BCryptPasswordEncoder().encode("secret"));
    }
}
