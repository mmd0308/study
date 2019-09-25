package com.hzqing.aspectj.demo1.impl;


import com.hzqing.aspectj.demo1.IUserService;
import com.hzqing.aspectj.demo1.User;

/**
 * @author hzqing
 * @date 2019-09-18 09:27
 */
public class UserServiceImpl implements IUserService {
    @Override
    public void insert(User user) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("新增用户");
    }

}
