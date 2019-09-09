package com.hzqing.demo7;

import java.util.*;

/**
 * @author hzqing
 * @date 2019-09-09 08:19
 */
public class User {

    private String username;

    private Car car;

    private int age;

    private List<String> list;

    private Set<Integer> set;

    private double[] array;

    private Properties properties;

    private Map<String,String> map;

    public User(String username, Car car, int age, List<String> list, Set<Integer> set, double[] array, Properties properties, Map<String, String> map) {
        this.username = username;
        this.car = car;
        this.age = age;
        this.list = list;
        this.set = set;
        this.array = array;
        this.properties = properties;
        this.map = map;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", car=" + car +
                ", age=" + age +
                ", list=" + list +
                ", set=" + set +
                ", array=" + Arrays.toString(array) +
                ", properties=" + properties +
                ", map=" + map +
                '}';
    }
}
