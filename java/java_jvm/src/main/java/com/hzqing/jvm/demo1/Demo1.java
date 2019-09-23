package com.hzqing.jvm.demo1;

/**
 * @author hzqing
 * @date 2019-09-23 14:42
 */
public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(Demo.x);
    }
}

class Demo{
    public static final int x = 3;
}
