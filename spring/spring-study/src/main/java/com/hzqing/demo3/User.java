package com.hzqing.demo3;

/**
 * @author hzqing
 * @date 2019-09-09 08:19
 */
public class User {

    private String username;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public void tosay(){
        System.out.println("username:" + username);
    }
}
