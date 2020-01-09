package com.hzqing.formework.context;

import com.hzqing.formework.annotation.HZQAutowired;
import com.hzqing.formework.annotation.HZQController;
import com.hzqing.formework.annotation.HZQService;
import com.hzqing.formework.beans.HZQBeanFactory;
import com.hzqing.formework.beans.HZQBeanWrapper;
import com.hzqing.formework.beans.config.HZQBeanDefinition;
import com.hzqing.formework.beans.support.HZQBeanDefinitionReader;
import com.hzqing.formework.beans.support.HZQDefaultListableBeanFactory;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Properties;
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
     * org.springframework.beans.factory.support.DefaultSingletonBeanRegistry
     */
    private Map<String,Object> singletonObjects = new ConcurrentHashMap<>();

    /**
     * 用来存储所有被代理过的对象
     * org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory
     */
    private Map<String,HZQBeanWrapper> factoryBeanInstanceCache = new ConcurrentHashMap<>();

    /**
     * 加载class文件等信息
     */
    HZQBeanDefinitionReader reader;

    public HZQApplicationContext(String configLocations) {
        this.configLocation = configLocations;
        // 初始化
        refresh();
    }

    @Override
    protected void refresh() {
        // 1、定位配置文件
        reader = new HZQBeanDefinitionReader(this.configLocation);

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
            super.beanDefinitionMap.put(definition.getBeanClassName(),definition);
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
        // 将BeanWrapper存储到Ioc容器中
        this.factoryBeanInstanceCache.put(beanName,beanWrapper);

        // 2、注入
        populateBean(beanName,instance);

        return this.factoryBeanInstanceCache.get(beanName).getWrappedInstance();
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
            String autowiredBeanName = autowired.value().trim();
            if ("".equals(autowiredBeanName)){
                autowiredBeanName = field.getName();
            }
            field.setAccessible(true);

            try {
                if (null == this.factoryBeanInstanceCache.get(autowiredBeanName)){
                    continue;
                }
                field.set(instance,this.factoryBeanInstanceCache.get(autowiredBeanName).getWrappedInstance());
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
                this.singletonObjects.put(definition.getBeanClassName(),object);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return object;
    }

    @Override
    public Object getBean(Class<?> beanClass) {
        return getBean(beanClass.getName());
    }

    /**
     * 将首字母小写
     * @param simpleName
     * @return
     */
    private String toLowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        // 首字母小写
        chars[0] += 32;
        return String.copyValueOf(chars);
    }

    /**
     * 获取配置文件中的信息
     * @return
     */
    public Properties getConfig(){
        return this.reader.getConfigContext();
    }
}
