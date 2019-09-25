package com.hzqing.springaop.demo1.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @author hzqing
 * @date 2019-09-19 09:20
 */
public class HzqThrowsAdvice implements ThrowsAdvice {

    /**
     *
     * @param method
     * @param args
     * @param target
     * @param ex
     */
    public void afterThrowing(Method method, Object[] args, Object target, Exception ex){
        System.out.println("---------异常增强---------");
    }
}
