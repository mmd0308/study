package com.hzqing.formework.beans;

/**
 * 单例工厂的顶层设计
 * @author hzqing
 * @date 2020-01-08 14:10
 */
@SuppressWarnings("all")
public interface HZQBeanFactory {

    /**
     * 根据bean名称，从Ioc容器中获取一个实例Bean
     * @param beanName
     * @return
     * @throws Exception
     */
    Object getBean(String beanName);

    Object getBean(Class<?> beanClass);
}
