package com.hzqing.formework.webmvc.servlet;

import com.hzqing.formework.annotation.HZQController;
import com.hzqing.formework.annotation.HZQRequestMapping;
import com.hzqing.formework.context.HZQApplicationContext;
import com.hzqing.formework.webmvc.HZQModelAndView;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hzqing
 * @date 2020-01-08 14:03
 */
@Slf4j
public class HZQDispatcherServlet extends HttpServlet {

    private HZQApplicationContext context;

    /**
     * 存储所有的url请求
     * org.springframework.web.servlet.DispatcherServlet
     */
    private List<HZQHandlerMapping> handlerMappings = new ArrayList<>();

    private Map<HZQHandlerMapping,HZQHandlerAdapter> handlerAdapters = new HashMap<HZQHandlerMapping, HZQHandlerAdapter>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doDispatcher(req,resp);

    }

    private void doDispatcher(HttpServletRequest req, HttpServletResponse resp) {
        //1、通过从Request中获取到Url，匹配HandlerMapping
        HZQHandlerMapping handlerMapping = getHandler(req);

        if (handlerMapping == null){
            // 404
            return;
        }
        //2、获取HandlerAdapter，准备参数
        HZQHandlerAdapter handlerAdapter = getHandlerAdapter(handlerMapping);

        //3、调用路径对应的方法,返回modelandview，存储了返回给页面的值及模版
        HZQModelAndView modelAndView = handlerAdapter.handle(req, resp, handlerMapping);

        //4、 将ModelAndView转换成HTML,Json等
        processDispatchResult(req, resp,modelAndView);


    }

    private void processDispatchResult(HttpServletRequest req, HttpServletResponse resp, HZQModelAndView modelAndView) {

    }

    private HZQHandlerAdapter getHandlerAdapter(HZQHandlerMapping handlerMapping) {
        if (this.handlerAdapters.isEmpty()){return null;}
        HZQHandlerAdapter handlerAdapter = this.handlerAdapters.get(handlerMapping);

        if (handlerAdapter.supports(handlerMapping)){
            return handlerAdapter;
        }
        return null;
    }

    private HZQHandlerMapping getHandler(HttpServletRequest req) {

        if (this.handlerMappings.isEmpty()) {return null;}

        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replace(contextPath,"").replaceAll("/+","/");
        for (HZQHandlerMapping handlerMapping : this.handlerMappings) {
            Matcher matcher = handlerMapping.getPattern().matcher(url);
            if (!matcher.matches()){continue;}
            return handlerMapping;
        }
        return null;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        // 1、 初始化ApplicationContext
        String contextConfigLoaction = config.getInitParameter("contextConfigLoaction");
        context = new HZQApplicationContext(contextConfigLoaction);

        // 2、 初始化Spring MVC九大组件
        initStrategies(context);
    }

    /**
     * 加载Spring MVC 九大策略
     * @param context
     */
    private void initStrategies(HZQApplicationContext context) {
        // 文件上传解析
        initMultipartResolver(context);
        // 本地化解析
        initLocaleResolver(context);
        // 主题解析
        initThemeResolver(context);

        // 通过HandlerMapping，将请求映射到处理器
        initHandlerMappings(context);


        // 通过HandlerAdapter进行多类型的参数动态匹配
        initHandlerAdapters(context);
        // 如果出现异常，initHandlerExceptionResolvers进行处理
        initHandlerExceptionResolvers(context);
        // 直接解析请求名的视图
        initRequestToViewNameTranslator(context);
        // 通过ViewResolvers解析逻辑视图到具体视图实现，暂时只处理json和html
        initViewResolvers(context);
        // flash 映射管理器
        initFlashMapManager(context);
    }

    private void initViewResolvers(HZQApplicationContext context) {
        // 1、模版存放目录 templateRoot
        String templateRoot = context.getConfig().getProperty("templateRoot");
    }

    private void initRequestToViewNameTranslator(HZQApplicationContext context) {

    }

    private void initHandlerExceptionResolvers(HZQApplicationContext context) {

    }

    /**
     * 将一个request请求变成一个Handler
     * @param context
     */
    private void initHandlerAdapters(HZQApplicationContext context) {
        if (this.handlerMappings.isEmpty()){return;}

        for (HZQHandlerMapping handlerMapping : this.handlerMappings) {
            // 每一个方法都有一个参数列表，那么这里保存的是行参列表
            this.handlerAdapters.put(handlerMapping,new HZQHandlerAdapter());
        }
    }

    /**
     * 将controller中配置的RequestMapping和Method进行匹配
     * @param context
     */
    private void initHandlerMappings(HZQApplicationContext context) {
        for (String beanName : context.getBeanDefinitionNames()) {
            Object bean = context.getBean(beanName);
            final Class<?> beanClass = bean.getClass();
            if (!beanClass.isAnnotationPresent(HZQController.class)){continue;}
            String baseUrl = "/";
            // 判断controller类上是否添加HZQRequestMapping注解
            if (beanClass.isAnnotationPresent(HZQRequestMapping.class)){
                final HZQRequestMapping requestMapping = beanClass.getAnnotation(HZQRequestMapping.class);
                baseUrl = baseUrl  + requestMapping.value();
            }
            for (Method method : beanClass.getDeclaredMethods()) {
                // 没有HZQRequestMapping注解的直接不处理
                if (!method.isAnnotationPresent(HZQRequestMapping.class)) {continue;}

                HZQRequestMapping mapping = method.getAnnotation(HZQRequestMapping.class);
                String url = (baseUrl + "/" +mapping.value().replaceAll("\\*",".*")).replaceAll("/+","/");

                Pattern pattern = Pattern.compile(url);
                this.handlerMappings.add(new HZQHandlerMapping(bean,method,pattern));
                log.info("HZQDispatcherServlet.initHandlerMappings");
            }
        }
    }

    private void initThemeResolver(HZQApplicationContext context) {

    }

    private void initLocaleResolver(HZQApplicationContext context) {
        
    }

    private void initMultipartResolver(HZQApplicationContext context) {

    }

    private void initFlashMapManager(HZQApplicationContext context) {

    }


}
