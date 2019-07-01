package com.hzqing.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hzqing
 * @date 2019-07-01 11:56
 */
public class ContainerSingleton {

    private ContainerSingleton(){

    }

    /**
     * 创建存储实例的容器
     */
    private static Map<String,Object> ioc = new ConcurrentHashMap<String, Object>();

    /**
     * 根据class的名称获取对象
     * @param className
     * @return
     */
    public static Object getBean(String className){
        synchronized (ioc){
            if (!ioc.containsKey(className)){
                Object obj = null;
                try {
                    //通过反射实例化对象
                    obj = Class.forName(className).getDeclaredConstructor().newInstance();
                    ioc.put(className,obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return  obj;

            } else {
                return ioc.get(className);

            }
        }
    }
}
