package com.hzqing.aop.demo3;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author hzqing
 * @date 2019-09-18 15:11
 */
public class PerformanceCGlibProxy implements MethodInterceptor {

    /**
     * 创建代理对象
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getInstance(Class<?> clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return (T) enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        long start = System.currentTimeMillis();
        Object res = methodProxy.invokeSuper(o, objects);
        System.out.println("执行 " + method.getName()+ " 方法花销了：" + (System.currentTimeMillis() - start) + " 毫秒");
        return res;
    }
}
