package com.hzqing.aop.demo1;

import lombok.Data;

/**
 * @author hzqing
 * @date 2019-09-18 09:27
 */
@Data
public class User {
    public User() {
    }
    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }
    private String id;

    private String name;
}
