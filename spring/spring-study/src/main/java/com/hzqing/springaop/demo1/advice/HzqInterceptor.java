package com.hzqing.springaop.demo1.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author hzqing
 * @date 2019-09-19 09:13
 */
public class HzqInterceptor implements MethodInterceptor {
    /**
     * MethodInvocation 不但封装了目标方法及其入参数据，还封装了目标方法所在的实例对象
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("--------环绕增强，方法调用前执行...");
        // 通过反射调用目标方法
        Object proceed = invocation.proceed();
        System.out.println("--------环绕增强，方法调用后执行...");
        return proceed;
    }
}
