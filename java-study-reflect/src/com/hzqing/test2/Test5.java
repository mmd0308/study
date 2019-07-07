package com.hzqing.test2;

import com.hzqing.User;

import java.lang.reflect.Method;

/**
 * @author hzqing
 * @date 2019-07-07 12:31
 */
public class Test5 {
    public static void main(String[] args) throws Exception {
        Class<User> userClass = User.class;

        System.out.println("------------------------获取所有的公共方法,包括父类的-------------------");
        Method[] methods = userClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("------------------------获取一个的公共无参数方法-------------------");
        Method getAge = userClass.getMethod("getAge");
        System.out.println(getAge);

        System.out.println("------------------------获取一个的公共有参数方法-------------------");
        Method testMethod = userClass.getMethod("testMethod", String.class);
        System.out.println(testMethod);

        System.out.println("------------------------获取本类中所有方法，包含私有方法-------------------");
        Method[] declaredMethods = userClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        System.out.println("------------------------获取一个的私有无参数方法-------------------");
        Method privateMethod = userClass.getDeclaredMethod("privateMethod");
        System.out.println(privateMethod);

        System.out.println("------------------------获取一个的私有有参数方法-------------------");
        Method privateMethod2 = userClass.getDeclaredMethod("privateMethod2", Integer.class);
        System.out.println(privateMethod2);


        System.out.println("------------------------通过反射调用公共有方法-------------------");
        User user = userClass.getDeclaredConstructor().newInstance();
        user.setAge(18);
        Method getAge1 = userClass.getMethod("getAge");
        // invoke(user, null); 第一个参数，指定调用那个对象的方法，第二个是调用方法的参数
        int invoke = (int) getAge1.invoke(user, null);
        System.out.println(invoke);

        System.out.println("------------------------通过反射调用私有有参方法-------------------");
        User user1 = userClass.getDeclaredConstructor().newInstance();
        Method privateMethod21 = userClass.getDeclaredMethod("privateMethod2",Integer.class);
        privateMethod21.setAccessible(true);
        privateMethod21.invoke(user1,18);


    }
}
