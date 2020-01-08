package com.hzqing.formework.beans;

/**
 * @author hzqing
 * @date 2020-01-08 14:13
 */
public class HZQBeanWrapper {

    private Object wrappedInstance;
    private Class<?> wrappedClass;

    public HZQBeanWrapper(Object wrappedInstance) {
        this.wrappedInstance = wrappedInstance;
    }

    public Object getWrappedInstance(){
        return this.wrappedInstance;
    }

    Class<?> getWrappedClass(){
        return null;
    }

}
