package com.hzqing.test2;

import java.lang.reflect.Constructor;

/**
 * @author hzqing
 * @date 2019-07-07 11:52
 */
public class Test2 {
    public static void main(String[] args) {
        try {
            Class<?> userClass = Class.forName("com.hzqing.User");

            System.out.println("------------------获取所有公共构造器-------------------------");
            // 获取所有公共的构造器
            Constructor<?>[] constructors = userClass.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }

            System.out.println("------------------获取指定一个指定参数类型的公共构造器-------------------------");
            Constructor<?> constructor = userClass.getConstructor(String.class);
            System.out.println(constructor);

            System.out.println("------------------获取所有公共构造器,包括私有构造器-------------------------");
            // 获取所有的构造器,包括私有的
            Constructor<?>[] declaredConstructors = userClass.getDeclaredConstructors();
            for (Constructor<?> declaredConstructor : declaredConstructors) {
                System.out.println(declaredConstructor);
            }

            System.out.println("------------------获取指定一个指定参数类型的构造器,可以是私有的-------------------------");
            // 注意：根据类型获取方法时候，基本数据类型（int，char...)和包装类是不同的类型
            Constructor<?> declaredConstructor = userClass.getDeclaredConstructor(int.class);
            System.out.println(declaredConstructor);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
