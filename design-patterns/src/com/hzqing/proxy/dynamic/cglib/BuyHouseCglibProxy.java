package com.hzqing.proxy.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author hzqing
 * @date 2019-07-03 09:11
 */
public class BuyHouseCglibProxy implements MethodInterceptor {

    public Object getInstance(Class<?> clazz){

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object obj = methodProxy.invokeSuper(o,objects);
        after();
        return obj;
    }

    private void after() {
        System.out.println("购房后...");
    }

    private void before() {
        System.out.println("购房前...");
    }
}
