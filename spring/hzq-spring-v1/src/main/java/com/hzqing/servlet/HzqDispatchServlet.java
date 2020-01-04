package com.hzqing.servlet;


import com.hzqing.annoation.HZQAutowired;
import com.hzqing.annoation.HZQController;
import com.hzqing.annoation.HZQRequestMapping;
import com.hzqing.annoation.HZQService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author hzqing
 * @date 2020-01-04 12:14
 */
public class HzqDispatchServlet extends HttpServlet {
    // 模型Spring Ioc 容器
    private Map<String,Object> mapping = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("500 服务器异常！");
        }
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException, InvocationTargetException, IllegalAccessException {
        final String requestURI = req.getRequestURI();
        final String contextPath = req.getContextPath();
        String url = requestURI.replace(contextPath,"").replaceAll("/+","/");
        if (!mapping.containsKey(url)){ resp.getWriter().write("404 页面不存在"); return;}

        Method method = (Method) mapping.get(url);
        Map<String,String[]> parameterMap = req.getParameterMap();
        // 调用方法
        method.invoke(mapping.get(method.getDeclaringClass().getName()),new Object[]{req,resp,parameterMap.get("name")[0]});
    }

    /**
     * tomcat启动，初始化操作
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        // 加载Spring配置文件
        InputStream inputStream = null;
        try {

            inputStream = this.getClass().getClassLoader().getResourceAsStream(config.getInitParameter("contextConfigLoaction"));
            Properties configContext = new Properties();
            configContext.load(inputStream);
            // 获取注解扫描包
            String scanPackage = configContext.getProperty("scanPackage");
            System.out.println("----------------------加载到的class文件 start ——————————————————————");
            doScanner(scanPackage);
            System.out.println("----------------------加载到的class文件 end ——————————————————————");
            // 通过for循环，实例化所有的Bean
            for (String className : mapping.keySet()) {
                if (!className.contains(".")){continue;}

                // 通过反射加载
                final Class<?> clazz = Class.forName(className);

                // 首先解析拥有@HZQController注解的controller
                if (clazz.isAnnotationPresent(HZQController.class)){
                    // 实例化Controller Bean
                    mapping.put(className,clazz.getConstructor().newInstance());
                    String baseUrl = "";
                    if (clazz.isAnnotationPresent(HZQRequestMapping.class)){
                        HZQRequestMapping requestMapping = clazz.getAnnotation(HZQRequestMapping.class);
                        // 获取controller类上面的请求路径
                        baseUrl = requestMapping.value();
                    }
                    // 遍历controller中的方法
                    for (Method method : clazz.getMethods()) {
                        if (!method.isAnnotationPresent(HZQRequestMapping.class)){continue;}

                        final HZQRequestMapping requestMapping = method.getAnnotation(HZQRequestMapping.class);
                        String url = (baseUrl + "/" + requestMapping.value()).replaceAll("/+", "/");
                        mapping.put(url,method);
                        System.out.println("Mapped " + url + " : " + method);
                    }
                }else if (clazz.isAnnotationPresent(HZQService.class)){
                    // 解析service
                    HZQService hzqService = clazz.getAnnotation(HZQService.class);
                    String beanName = hzqService.value();
                    if ("".equals(beanName)){ beanName = clazz.getName();}
                    // 实例化service
                    final Object service = clazz.getConstructor().newInstance();
                    mapping.put(beanName,service);
                    // 遍历接口
                    for (Class<?> clazzInterface : clazz.getInterfaces()) {
                        // 根据类型就行实例化
                        mapping.put(clazzInterface.getName(),service);
                    }
                }
            }
            // Bean 进行注入
            for (Object value : mapping.values()) {
                if (value == null) {continue;}
                final Class<?> aClass = value.getClass();
                // 向controller中注入service
                if (aClass.isAnnotationPresent(HZQController.class)){
                    for (Field field : aClass.getDeclaredFields()) {
                        HZQAutowired fieldAnnotation = field.getAnnotation(HZQAutowired.class);
                        String beanName = fieldAnnotation.value();
                        if ("".equals(beanName)) {beanName = field.getType().getName();}
                        field.setAccessible(true);
                        // 给成员变量设置值
                        field.set(mapping.get(aClass.getName()),mapping.get(beanName));
                    }
                }
            }
            // 初始化完成后，遍历mapping
            System.out.println("----------最终map中存储的值 start -----------");
            for (String key : mapping.keySet()) {
                System.out.println(key + " ： " + mapping.get(key));
            }
            System.out.println("----------最终map中存储的值 end -----------");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void doScanner(String scanPackage) {
        final URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        File file = new File(url.getFile());
        for (File fil : file.listFiles()){
            if (fil.isDirectory()){
                doScanner(scanPackage + "." + fil.getName());
            }else {
                if (!fil.getName().endsWith(".class")) {continue;}
                String clazzName = scanPackage + "." + fil.getName().replace(".class","");

                System.out.println(clazzName);
                // 将所有的class文件，以key的形式存储到mapping中
                mapping.put(clazzName,null);
            }
        }
    }
}
