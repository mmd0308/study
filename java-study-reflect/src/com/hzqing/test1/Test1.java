package com.hzqing.test1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hzqing
 * @date 2019-07-07 10:47
 */
public class Test1 {

    public static void main(String[] args) throws Exception {
        Class<ArrayList> arrayListClass = ArrayList.class;
        System.out.println(arrayListClass);

        Class<?> aClass = Class.forName("java.util.ArrayList");
        System.out.println(aClass);

        List list = new ArrayList<>();
        Class<? extends List> aClass1 = list.getClass();
        System.out.println(aClass1);
    }
}
