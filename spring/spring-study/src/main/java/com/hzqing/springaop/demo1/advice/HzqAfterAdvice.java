package com.hzqing.springaop.demo1.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author hzqing
 * @date 2019-09-19 09:11
 */
public class HzqAfterAdvice implements AfterReturningAdvice {
    /**
     *
     * @param returnValue 目标实例方法返回的结果
     * @param method 目标类的方法
     * @param args 目标实例方法的入参
     * @param target 目标实例
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("调用后置增强---");
    }
}
