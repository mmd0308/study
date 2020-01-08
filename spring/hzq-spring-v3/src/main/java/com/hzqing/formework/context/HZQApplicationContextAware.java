package com.hzqing.formework.context;

/**
 * 通过解藕方式获取Ioc容器的顶层设计
 * 后期通过一个监听器去扫描所有的类，只要实现了此接口
 * 将自动调用setApplicationContext()方法，从而将Ioc容器注入到目标类中
 * @author hzqing
 * @date 2020-01-08 15:07
 */
public interface HZQApplicationContextAware {

    void setApplicationContext(HZQApplicationContext applicationContext);
}
