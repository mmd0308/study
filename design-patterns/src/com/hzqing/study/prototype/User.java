package com.hzqing.study.prototype;

/**
 * @author hzqing
 * @date 2019-07-02 10:55
 */
public class User {
    private String name;

    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}
