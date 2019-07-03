package com.hzqing.delegate;

/**
 * @author hzqing
 * @date 2019-07-03 13:52
 */
public class Test {
    public static void main(String[] args) {
        Boss boss = new Boss();
        boss.commd("B",new Leader());
    }
}
