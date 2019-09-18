package com.hzqing.aop.demo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hzqing
 * @date 2019-09-18 09:29
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class App {

    @Autowired
    private IUserService userService;

    @Test
    public void test(){
        userService.insert(new User("1","hzqing"));
    }
}
