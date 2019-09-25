package com.hzqing.springaop.demo1.impl;


import com.hzqing.springaop.demo1.IUserService;
import com.hzqing.springaop.demo1.User;

/**
 * @author hzqing
 * @date 2019-09-18 09:27
 */
public class UserServiceImpl implements IUserService {

    @Override
    public void insert(User user) {
        System.out.println("调用用户用户方法,新增用户：" +user);
        throw new RuntimeException("抛出异常");
    }
}
