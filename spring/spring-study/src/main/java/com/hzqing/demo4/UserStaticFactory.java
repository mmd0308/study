package com.hzqing.demo4;

/**
 * @author hzqing
 * @date 2019-09-09 11:02
 */
public class UserStaticFactory {

    public static User createUser(){
        return new User("hzqing");
    }
}
