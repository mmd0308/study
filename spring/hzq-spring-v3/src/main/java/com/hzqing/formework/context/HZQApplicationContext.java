package com.hzqing.formework.context;

import com.hzqing.formework.annotation.HZQAutowired;
import com.hzqing.formework.annotation.HZQController;
import com.hzqing.formework.annotation.HZQService;
import com.hzqing.formework.beans.*;
import com.hzqing.formework.beans.config.HZQBeanDefinition;
import com.hzqing.formework.beans.support.HZQBeanDefinitionReader;
import com.hzqing.formework.beans.support.HZQDefaultListableBeanFactory;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hzqing
 * @date 2020-01-08 14:40
 */
public class HZQApplicationContext extends HZQDefaultListableBeanFactory implements HZQBeanFactory{

    /**
     * 配置文件的路径
     */
    private String configLocation;

    /**
     * 单例的IOC容器缓存
     */
    private Map<String,Object> singletonObjects = new ConcurrentHashMap<>();

    /**
     * 用来存储所有被代理过的对象
     */
    private Map<String,HZQBeanWrapper> beanWrapperMap = new ConcurrentHashMap<>();


    public HZQApplicationContext(String configLocations) {
        this.configLocation = configLocations;
    }

    @Override
    protected void refresh() {
        // 1、定位配置文件
        HZQBeanDefinitionReader reader = new HZQBeanDefinitionReader(this.configLocation);

        // 2、加载配置文件，扫描相关的类，把它们封装成BeanDefinition
        List<HZQBeanDefinition> definitions =  reader.loadBeanDefinitions();

        // 3、注册，把配置信息放到容器里面
        doRegisterBeanDefinition(definitions);

        // 4、实例化非延迟加载的类
        doInstance();
    }

    private void doInstance() {
        for (Map.Entry<String, HZQBeanDefinition> definitionEntry : super.beanDefinitionMap.entrySet()) {
            String beanName = definitionEntry.getKey();
            // 实例化非延迟加载
            if (!definitionEntry.getValue().isLazyInit()){
                getBean(beanName);
            }
        }

    }


    private void doRegisterBeanDefinition(List<HZQBeanDefinition> definitions) {
        for (HZQBeanDefinition definition : definitions) {
            super.beanDefinitionMap.put(definition.getFactoryBeanName(),definition);
        }
    }

    @Override
    public Object getBean(String beanName) {
        HZQBeanDefinition definition = this.beanDefinitionMap.get(beanName);

        /**
         *1、 初始化
         * 先初始化，后注入，避免循环依赖
         */
        Object instance = initializeBean(definition);

        HZQBeanWrapper beanWrapper = new HZQBeanWrapper(instance);
        this.beanWrapperMap.put(beanName,beanWrapper);

        // 2、注入
        populateBean(beanName,instance);


        return this.beanWrapperMap.get(beanName).getWrappedInstance();
    }

    /**
     * 注入
     * @param beanName
     * @param instance
     */
    private void populateBean(String beanName, Object instance) {
        final Class<?> instanceClass = instance.getClass();
        if (!(instanceClass.isAnnotationPresent(HZQController.class) || instanceClass.isAnnotationPresent(HZQService.class))){return;}

        for (Field field : instanceClass.getDeclaredFields()) {
            // 没有@Autowirred注解的成员变量
            if (!field.isAnnotationPresent(HZQAutowired.class)){continue;}

            HZQAutowired autowired = field.getAnnotation(HZQAutowired.class);
            String autowiredBeanName = autowired.value();
            if ("".equals(autowiredBeanName)){
                autowiredBeanName = field.getType().getName();
            }
            field.setAccessible(true);

            try {
                field.set(instance,this.beanWrapperMap.get(autowiredBeanName).getWrappedInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }


        }


    }

    private Object initializeBean(HZQBeanDefinition definition) {
        // 如果存在，直接返回
        Object object = null;
        if (this.singletonObjects.containsKey(definition.getFactoryBeanName())){
            object =  singletonObjects.get(definition.getFactoryBeanName());
        }else {
            try {
                final Class<?> clazz = Class.forName(definition.getBeanClassName());
                object = clazz.getConstructor().newInstance();
                // 将实例化的对象，存储到Ioc容器中
                this.singletonObjects.put(definition.getFactoryBeanName(),object);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return object;
    }

    @Override
    public Object getBean(Class<?> beanClass) {
        return null;
    }
}
