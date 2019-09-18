package com.hzqing.aop.demo2.impl;

import com.hzqing.aop.demo2.IUserService;
import com.hzqing.aop.demo2.User;

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

    @Override
    public void update(User user) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("修改用户");
    }
    @Override
    public User get(String id) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("根据id获取用户");
        return new User("1","hzqing");
    }
}
