package com.hzqing.aop.demo1;

/**
 * @author hzqing
 * @date 2019-09-18 09:26
 */
public interface IUserService {

    void insert(User user);

    void update(User user);

    User get (String id);
}
