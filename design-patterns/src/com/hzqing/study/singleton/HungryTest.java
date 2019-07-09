package com.hzqing.study.singleton;

/**
 * @author hzqing
 * @date 2019-07-01 09:37
 */
public class HungryTest {
    public static void main(String[] args) {
        HungrySingleton hungrySingleton1 = HungrySingleton.getInstance();
        HungrySingleton hungrySingleton2 = HungrySingleton.getInstance();

        System.out.println(hungrySingleton1);
        System.out.println(hungrySingleton2);
        System.out.println(hungrySingleton1 == hungrySingleton2);
    }
}
