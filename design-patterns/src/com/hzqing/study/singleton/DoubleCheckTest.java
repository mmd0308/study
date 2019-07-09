package com.hzqing.study.singleton;

/**
 * @author hzqing
 * @date 2019-07-01 09:49
 */
public class DoubleCheckTest {
    public static void main(String[] args) {
        DoubleCheckSingleton doubleCheckSingleton1 = DoubleCheckSingleton.getInstance();
        DoubleCheckSingleton doubleCheckSingleton2 = DoubleCheckSingleton.getInstance();

        System.out.println(doubleCheckSingleton1);
        System.out.println(doubleCheckSingleton2);
        System.out.println(doubleCheckSingleton1 == doubleCheckSingleton2);
    }
}
