package com.hzqing.study.singleton;

/**
 * @author hzqing
 * @date 2019-07-01 12:05
 */
public class ContainerTest {
    public static void main(String[] args) {
        Object object1 = ContainerSingleton.getBean("com.hzqing.study.singleton.ContainerSingleton");
        Object object2 = ContainerSingleton.getBean("com.hzqing.study.singleton.ContainerSingleton");

        System.out.println(object1);
        System.out.println(object2);
        System.out.println(object1 == object2);
    }
}
