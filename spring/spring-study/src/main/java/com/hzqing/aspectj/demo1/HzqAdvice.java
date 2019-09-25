package com.hzqing.aspectj.demo1;

/**
 * @author hzqing
 * @date 2019-09-25 15:07
 */
public class HzqAdvice {

    public void before() {
        System.out.println("---调用前置增强");
    }

    public void after(){
        System.out.println("调用后置增强");
    }
}
