package com.hzqing.prototype;

import java.util.ArrayList;

/**
 * @author hzqing
 * @date 2019-07-02 10:33
 */
public class ListClient {
    public static void main(String[] args) {
        ArrayList<User> a = new ArrayList<>();
        a.add(new User("zhangsan",18));

        ArrayList<User> b = a;

        System.out.println("a == b : " + (a == b));
        System.out.println("a中用户对象： " + a.get(0));
        System.out.println("b中用户对象： " + b.get(0));

        ArrayList<User> c = (ArrayList<User>) a.clone();
        System.out.println("a == c : " + (c == a));
        System.out.println("c中存储用户对象: " + c.get(0));
        System.out.println("c中存储的用户和a中存储的是否是一个用户： " + (c.get(0) == b.get(0)));

    }
}
