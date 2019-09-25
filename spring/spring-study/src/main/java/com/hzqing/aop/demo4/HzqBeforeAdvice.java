package com.hzqing.aop.demo4;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author hzqing
 * @date 2019-09-23 09:09
 */
public class HzqBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("前置增强");
    }
}
