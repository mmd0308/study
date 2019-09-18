package com.hzqing.aop.demo3.impl;

import com.hzqing.aop.demo3.User;

/**
 * @author hzqing
 * @date 2019-09-18 09:27
 */
public class UserServiceImpl  {
    public void insert(User user) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("新增用户");
    }
}
