package com.hzqing.aop.demo3;

import com.hzqing.aop.demo3.impl.UserServiceImpl;
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
    private PerformanceCGlibProxy performanceCGlibProxy;

    @Test
    public void test(){
        UserServiceImpl userService = performanceCGlibProxy.getInstance(UserServiceImpl.class);
        userService.insert(new User("1","hzqing"));
    }
}
