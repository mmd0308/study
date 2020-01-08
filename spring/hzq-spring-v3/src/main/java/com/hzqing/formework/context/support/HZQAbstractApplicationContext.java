package com.hzqing.formework.context.support;

import com.hzqing.formework.beans.HZQBeanFactory;

/**
 * Ioc 容器实现的顶层设计
 * @author hzqing
 * @date 2020-01-08 14:45
 */
public abstract class HZQAbstractApplicationContext {

    /***
     * 限制权限，只允许子类进行重写
     */
    protected void refresh(){}
}
