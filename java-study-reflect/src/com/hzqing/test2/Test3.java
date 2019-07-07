package com.hzqing.test2;

import com.hzqing.User;

import java.lang.reflect.Constructor;

/**
 * @author hzqing
 * @date 2019-07-07 11:52
 */
public class Test3 {
    public static void main(String[] args) {
        try {
            Class<?> userClass = Class.forName("com.hzqing.User");

            System.out.println("------------------根据公共无参数构造器实例话对象-------------------------");
            Constructor<?> constructor1 = userClass.getConstructor();
            User user1 = (User) constructor1.newInstance();
            System.out.println(user1);

            System.out.println("------------------根据公共有参构造器实例化对象-------------------------");
            Constructor<?> constructor2 = userClass.getConstructor(String.class);
            User user2 = (User) constructor2.newInstance("张三");
            System.out.println(user2);

            System.out.println("------------------根据私有无参构造器实例化对象-------------------------");
            Constructor<?> declaredConstructor1 = userClass.getDeclaredConstructor();
            // 关闭Java语言访问检查
            declaredConstructor1.setAccessible(true);
            User user3 = (User) declaredConstructor1.newInstance();
            System.out.println(user3);

            System.out.println("------------------根据私有有参构造器实例化对象-------------------------");
            Constructor<?> declaredConstructor2 = userClass.getDeclaredConstructor(int.class);
            declaredConstructor2.setAccessible(true);
            User user4 = (User) declaredConstructor2.newInstance(18);
            System.out.println(user4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
