package com.hzqing.formework.beans.support;

import com.hzqing.formework.beans.config.HZQBeanDefinition;
import com.hzqing.formework.context.support.HZQAbstractApplicationContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hzqing
 * @date 2020-01-08 14:50
 */
public class HZQDefaultListableBeanFactory extends HZQAbstractApplicationContext {

    /**
     * 存储注册信息的BeanDefinition
     */
    protected final Map<String, HZQBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    /**
     * 获取所有的bean名称
     * @return
     */
    public String[] getBeanDefinitionNames(){
        return beanDefinitionMap.keySet().toArray(new String[beanDefinitionMap.size()]);
    }
}
