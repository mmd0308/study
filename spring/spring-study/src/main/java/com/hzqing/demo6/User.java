package com.hzqing.demo6;

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

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<Integer> set) {
        this.set = set;
    }

    public void setArray(double[] array) {
        this.array = array;
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
