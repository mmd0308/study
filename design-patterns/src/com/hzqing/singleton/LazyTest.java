package com.hzqing.singleton;

/**
 * @author hzqing
 * @date 2019-07-01 09:43
 */
public class LazyTest  {
    public static void main(String[] args) {
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();

        System.out.println(lazySingleton1);
        System.out.println(lazySingleton2);
        System.out.println(lazySingleton1 == lazySingleton2);
    }
}
