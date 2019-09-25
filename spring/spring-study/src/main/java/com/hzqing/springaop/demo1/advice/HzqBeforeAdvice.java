package com.hzqing.springaop.demo1.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author hzqing
 * @date 2019-09-19 08:58
 */
public class HzqBeforeAdvice implements MethodBeforeAdvice {
    /**
     *
     * @param method 目标类方法
     * @param args 目标类方法参数
     * @param target 目标类实例对象
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("---调用前置增强");
    }
}
