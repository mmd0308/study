package com.hzqing.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author hzqing
 * @date 2019-07-03 08:43
 */
public class BuyHouseJdkProxy implements InvocationHandler {

    private Object object;

    public Object getInstance(Object object) {
        this.object = object;
        Class<?> objectClass = object.getClass();
        return Proxy.newProxyInstance(objectClass.getClassLoader(),objectClass.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(object, args);
        after();
        return invoke;
    }

    private void before() {
        System.out.println("购房前...");
    }
    private void after(){
        System.out.println("购房后...");
    }
}
