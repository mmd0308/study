package com.hzqing.mybatis.mapper;

import com.hzqing.mybatis.entity.Blog;

import java.util.List;

/**
 * @author hzqing
 * @date 2019-08-09 08:48
 */
public interface BlogMapper {

    List<Blog> selectLists();

    void insert(Blog blog);
}
