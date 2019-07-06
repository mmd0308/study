package com.hzqing.mapper;

import com.hzqing.domain.User;

import java.util.List;

/**
 * @author hzqing
 * @date 2019-07-06 11:29
 */
public interface UserMapper {
    List<User> selectList();
}
