package com.hzqing;

/**
 * @author hzqing
 * @date 2019-07-07 10:46
 */
public class User {

    private int age;

    private String name;

    public String sex;

    public User() {
    }

    private User(int age) {
        this.age = age;
    }

    public User(String name) {
        this.name = name;
    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }
    private void privateMethod2(Integer integer){
        System.out.println("这是一个私有有参数方法，参数是：" + integer);
    }

    private void privateMethod(){
        System.out.println("这是一个私有方法");
    }

    public void testMethod(String str){
        System.out.println("参数数：" + str);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
