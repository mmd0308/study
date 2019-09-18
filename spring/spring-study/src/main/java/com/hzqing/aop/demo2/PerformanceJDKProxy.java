package com.hzqing.aop.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author hzqing
 * @date 2019-09-18 15:11
 */
public class PerformanceJDKProxy implements InvocationHandler {

    /**
     * 被代理的真实对象
     */
    private Object target;

    public PerformanceJDKProxy(Object target) {
        this.target = target;
    }

    /**
     * 生成代理对象
     * @param <T>
     * @return
     */
    public <T> T getProxyObjcet(){
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this
                );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        // 调用真实对象的方法
        Object invoke = method.invoke(target, args);
        System.out.println("执行 " + method.getName()+ " 方法花销了：" + (System.currentTimeMillis() - start) + " 毫秒");
        return invoke;
    }
}
