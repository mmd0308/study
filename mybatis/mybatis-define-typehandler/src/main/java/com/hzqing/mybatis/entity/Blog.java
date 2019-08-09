package com.hzqing.mybatis.entity;

import lombok.Data;

/**
 * @author hzqing
 * @date 2019-08-09 08:40
 */
@Data
public class Blog {

    private int id;

    private String title;

    private Comment comment;
}
