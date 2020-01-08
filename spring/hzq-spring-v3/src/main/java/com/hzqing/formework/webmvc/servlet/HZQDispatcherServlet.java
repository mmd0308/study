package com.hzqing.formework.webmvc.servlet;

import com.hzqing.formework.context.HZQApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hzqing
 * @date 2020-01-08 14:03
 */
public class HZQDispatcherServlet extends HttpServlet {

    private HZQApplicationContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
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
        // 通过ViewResolvers解析逻辑视图到具体视图实现
        initViewResolvers(context);
        // flash 映射管理器
        initFlashMapManager(context);
    }

    private void initViewResolvers(HZQApplicationContext context) {

    }

    private void initRequestToViewNameTranslator(HZQApplicationContext context) {

    }

    private void initHandlerExceptionResolvers(HZQApplicationContext context) {

    }

    private void initHandlerAdapters(HZQApplicationContext context) {

    }

    /**
     * 将controller中配置的RequestMapping和Method进行匹配
     * @param context
     */
    private void initHandlerMappings(HZQApplicationContext context) {

    }

    private void initThemeResolver(HZQApplicationContext context) {

    }

    private void initLocaleResolver(HZQApplicationContext context) {
        
    }

    private void initMultipartResolver(HZQApplicationContext context) {

    }

    private void initFlashMapManager(HZQApplicationContext context) {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
