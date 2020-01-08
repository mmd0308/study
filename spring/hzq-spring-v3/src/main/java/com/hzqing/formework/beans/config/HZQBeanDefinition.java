package com.hzqing.formework.beans.config;

import lombok.Data;

/**
 * 用来存储配置文件中的信息
 * 相当于保存内存中的配置
 * @author hzqing
 * @date 2020-01-08 14:12
 */
@Data
public class HZQBeanDefinition {

    private String beanClassName;

    private boolean lazyInit = false;

    private String factoryBeanName;
}
