package com.hzqing.domain;

/**
 * @author hzqing
 * @date 2019-07-07 14:50
 */
public class UserInfo {
    private int age;
    private String name;

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public UserInfo() {
    }

    public UserInfo(int var1) {
        this.age = var1;
    }
}
