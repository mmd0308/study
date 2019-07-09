package com.hzqing.study.delegate;

/**
 * @author hzqing
 * @date 2019-07-03 13:46
 */
public class EmployeeB implements IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("EmployeeB 正在干活...");
    }
}
