package com.hzqing.study.aliases;

import org.apache.ibatis.type.Alias;

/**
 * @author hzqing
 * @date 2019-07-09 20:52
 */
@Alias("user")
public class User {
    private int id;
    private String username;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
