package com.hzqing.user.service.impl;

import com.hzqing.annoation.HZQService;
import com.hzqing.user.service.IUserService;

/**
 * @author hzqing
 * @date 2020-01-04 14:26
 */
@HZQService
public class UserServiceImpl implements IUserService {

    @Override
    public String get(String name) {
        return "Hello " + name;
    }
}
