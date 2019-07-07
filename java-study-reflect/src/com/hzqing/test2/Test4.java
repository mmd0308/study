package com.hzqing.test2;

import com.hzqing.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author hzqing
 * @date 2019-07-07 11:52
 */
public class Test4 {
    public static void main(String[] args) {
        try {
            Class<?> userClass = Class.forName("com.hzqing.User");

            System.out.println("------------------获取所有公共的属性-------------------------");
            // 获取所有公共的属性
            Field[] fields = userClass.getFields();
            for (Field field : fields) {
                System.out.println(field);
            }

            System.out.println("-------------------获取一个指定的公共属性------------------------");
            // 获取一个指定的公共属性
            Field age = userClass.getField("sex");
            System.out.println(age);

            System.out.println("-------------------获取所有的属性，包含私有属性------------------------");
            // 获取说有的私有属性
            Field[] declaredFields = userClass.getDeclaredFields();
            for (Field field : declaredFields) {
                System.out.println(field);
            }

            System.out.println("-------------------获取指定一个属性，可以是私有属性------------------------");
            Field sex = userClass.getDeclaredField("sex");
            System.out.println(sex);
            Field age1 = userClass.getDeclaredField("age");
            System.out.println(age1);

            System.out.println("-------------------给一个公共属性设置值------------------------");
            User user = (User) userClass.getDeclaredConstructor().newInstance();
            Field sex1 = userClass.getField("sex");
            sex1.set(user,"男");
            System.out.println(user.sex);

            System.out.println("-------------------给一个私有属性设置值------------------------");
            User user1 = (User) userClass.getDeclaredConstructor().newInstance();
            Field name = userClass.getDeclaredField("name");
            name.setAccessible(true);
            name.set(user1,"张三");
            System.out.println(user1.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
