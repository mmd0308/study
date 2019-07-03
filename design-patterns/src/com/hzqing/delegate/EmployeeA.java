package com.hzqing.delegate;

/**
 * @author hzqing
 * @date 2019-07-03 13:46
 */
public class EmployeeA implements IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("EmployeeA 正在干活....");
    }
}
