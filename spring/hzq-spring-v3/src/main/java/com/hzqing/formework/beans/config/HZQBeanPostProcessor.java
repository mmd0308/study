package com.hzqing.formework.beans.config;

/**
 * @author hzqing
 * @date 2020-01-09 14:00
 */
public class HZQBeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }
}
