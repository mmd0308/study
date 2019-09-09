package com.hzqing.demo8;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hzqing
 * @date 2019-09-09 08:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class App {

    @Autowired
    private Benz benz1;

    @Autowired
    private Benz benz2;

    @Test
    public void test1(){
        System.out.println(benz1);
        System.out.println(benz2);
    }
}
