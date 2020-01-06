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
import java.util.*;

/**
 * @author hzqing
 * @date 2020-01-05 08:57
 */
@SuppressWarnings("all")
public class HZQDispatchServlet extends HttpServlet {
    // 配置文件
    Properties properties = new Properties();

    // 模拟Ioc容器
    private Map<String,Object> ioc = new HashMap<>();

    // 保存所有被扫描到的类名称
    private Set<String> classNames = new HashSet<>();

    // 存储所有的url请求
    private Map<String,Method> handlerMapping = new HashMap<>();

    /**
     * 初始化阶段
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        // 1、加载配置文件
        doLoadConfig(config.getInitParameter("contextConfigLocation"));

        // 2、扫描相关的类
        doScanner(properties.getProperty("scanPackage"));

        // 3、初始化扫描类，并且将它们放入到Ioc容器中
        doInstance();

        // 4、完成依赖注入DI
        doAutowired();

        // 5、初始化HanderMapping
        initHandlerMapping();

    }

    private void doAutowired() {
        if (ioc.isEmpty()) {return;}
        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            // 所有的成员变量
            final Field[] fields = entry.getValue().getClass().getDeclaredFields();
            for (Field field : fields) {
                if (!field.isAnnotationPresent(HZQAutowired.class)) {continue;}
                HZQAutowired autowired = field.getAnnotation(HZQAutowired.class);
                String beanName = autowired.value();
                if ("".equals(beanName)){
                    // 获取接口的类型，作为key从ioc容器中获取实例
                    beanName = field.getType().getName();
                }
                field.setAccessible(true);
                try {
                    // 完成DI注入
                    field.set(entry.getValue(),ioc.get(beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private void initHandlerMapping() {
       if (ioc.isEmpty()) {return;}
        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            final Class<?> clazz = entry.getValue().getClass();
            if (!clazz.isAnnotationPresent(HZQController.class)) {continue;}

            String baseUrl = "";
            // 获取controller类上面的url
            if (clazz.isAnnotationPresent(HZQRequestMapping.class)){
                final HZQRequestMapping requestMapping = clazz.getAnnotation(HZQRequestMapping.class);
                baseUrl = requestMapping.value();
            }

            // 获取所有的public方法
            for (Method method : clazz.getMethods()) {
                if (!method.isAnnotationPresent(HZQRequestMapping.class)){continue;}
                final HZQRequestMapping requestMapping = method.getAnnotation(HZQRequestMapping.class);
                String url = "/" + baseUrl + "/" + requestMapping.value();
                // 去除路径中多余的斜杠
                url = url.replaceAll("/+","/");
                handlerMapping.put(url,method);
            }

        }
    }

    private void doInstance() {
        if (classNames.isEmpty()) {return;}
        for (String className : classNames) {
            try {
                final Class<?> clazz = Class.forName(className);
                // 实例化加了注解的类
                if (clazz.isAnnotationPresent(HZQController.class)){
                    // 实例化类
                    final Object instance = clazz.getConstructor().newInstance();
                    // 获取类名称首字母小写
                    String beanName = toLowerFirstCase(clazz.getSimpleName());
                    ioc.put(beanName,instance);
                }else if (clazz.isAnnotationPresent(HZQService.class)){
                    final HZQService hzqService = clazz.getAnnotation(HZQService.class);
                    // 获取自定义的beanName
                    String beanName = hzqService.value();
                    if (beanName.equals("")){
                        beanName = toLowerFirstCase(clazz.getSimpleName());
                    }
                    Object instance = clazz.getConstructor().newInstance();
                    ioc.put(beanName,instance);
                    // 根据类型自动装配
                    for (Class<?> anInterface : clazz.getInterfaces()) {
                        if (!ioc.containsKey(anInterface.getName())){
                            ioc.put(anInterface.getName(),instance);
                        }
                    }
                }else {
                    continue;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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


    private void doScanner(String scanPackage) {
        URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        File classPath = new File(url.getFile());
        // 遍历所有的文件
        for (File file : classPath.listFiles()) {
            if (file.isDirectory()) { doScanner(scanPackage + "." + file.getName());}
            else {
                if (!file.getName().endsWith(".class")){continue;}
                // 获取所有的class文件名称
                String className = (scanPackage + "." +file.getName().replace(".class",""));
                classNames.add(className);
            }
        }
    }

    private void doLoadConfig(String contextConfigLocation) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        try {
            doDispatch(req,resp);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException, InvocationTargetException, IllegalAccessException {
        String uri = req.getRequestURI();
        String contextPath = req.getContextPath();
        // 获取请求url
        final String url = uri.replace(contextPath, "").replaceAll("/+", "/");
        if (!this.handlerMapping.containsKey(url)){
            resp.getWriter().write("404 页面不存在");
            return;
        }
        // 获取该请求url对应的方法
        Method method = this.handlerMapping.get(url);
        // 从Ioc容器中，获取该方法对应的bean
        String beanName = toLowerFirstCase(method.getDeclaringClass().getSimpleName());
        final Map<String,String[]> parameterMap = req.getParameterMap();
        // 调用url对应的方法
        method.invoke(ioc.get(beanName),new Object[]{req,resp,parameterMap.get("name")[0]});
    }
}
