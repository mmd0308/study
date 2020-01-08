package com.hzqing.formework.beans.support;

import com.hzqing.formework.beans.config.HZQBeanDefinition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author hzqing
 * @date 2020-01-08 15:21
 */
public class HZQBeanDefinitionReader {

    /**
     * 配置文件信息
     */
    private Properties configContext = new Properties();
    /**
     * 配置文件常量，指定扫描的包路径
     */
    private final static String SCAN_PACKAGE  = "scanPackage";

    /**
     * 存储所有的class名称
     */
    private List<String> registryBeanclassNames = new ArrayList<>();


    public HZQBeanDefinitionReader(String configLocation) {
        final InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(configLocation);
        try {
            configContext.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 扫描包，获取所有的class文件
        doScanner(SCAN_PACKAGE);
    }

    private void doScanner(String scanPackage) {
        URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.","/"));
        File classPath = new File(url.getFile());
        for (File file : classPath.listFiles()) {
            if (file.isDirectory()) {doScanner(scanPackage + "." + file.getName());}
            else {
                if (!file.getName().endsWith(".class")){continue;}
                // 保存所有的class文件名称
                String className = scanPackage + "." + file.getName().replace(".class","");
                registryBeanclassNames.add(className);
            }

        }

    }

    /**
     * 将配置文件中的所有配置信息,转换成BeanDefinition
     * @return
     */
    public List<HZQBeanDefinition> loadBeanDefinitions(){
        if (registryBeanclassNames.isEmpty()){return null;}
        /**
         * 将所有的class封装成BeanDefinition存储
         */
        List<HZQBeanDefinition> definitions = new ArrayList<>();
        for (String beanclassName : registryBeanclassNames) {
            HZQBeanDefinition definition = doCreateBeanDefinition(beanclassName);
            if (null == definition) { continue; }
            definitions.add(definition);
        }
        return definitions;
    }

    /**
     * 根据class名称创建BeanDefinition
     * @param beanclassName
     * @return
     */
    private HZQBeanDefinition doCreateBeanDefinition(String beanclassName) {
        try {
            Class<?> clazz = Class.forName(beanclassName);
            // 如果是接口
            if (clazz.isInterface()){return null;}
            HZQBeanDefinition definition = new HZQBeanDefinition();
            definition.setBeanClassName(beanclassName);
            definition.setFactoryBeanName(this.toLowerFirstCase(clazz.getSimpleName()));
            return definition;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
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
}
