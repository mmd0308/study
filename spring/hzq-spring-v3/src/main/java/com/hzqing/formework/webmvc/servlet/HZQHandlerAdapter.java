package com.hzqing.formework.webmvc.servlet;

import com.hzqing.formework.annotation.HZQRequestParam;
import com.hzqing.formework.webmvc.HZQModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hzqing
 * @date 2020-01-09 14:48
 */
public class HZQHandlerAdapter {


    public boolean supports(Object handler){
        return (handler instanceof HZQHandlerMapping);
    }

    HZQModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        HZQHandlerMapping handlerMapping = (HZQHandlerMapping) handler;

        //每一个方法有一个参数列表，那么这里保存的是形参列表
        Map<String,Integer> paramMapping = new HashMap<String, Integer>();
        //这里只是出来了命名参数
        Annotation[][] pa = handlerMapping.getMethod().getParameterAnnotations();

        for (int i = 0; i < pa.length; i++) {
            for (Annotation annotation : pa[i]) {
                if (annotation instanceof HZQRequestParam){
                    String paramName = ((HZQRequestParam) annotation).value();
                    if (!"".equals(paramName.trim())){
                        paramMapping.put(paramName,i);
                    }
                }
            }
        }

        // 1、处理Request和Response
        final Class<?>[] parameterTypes = handlerMapping.getMethod().getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            final Class<?> parameterType = parameterTypes[i];
            if (parameterType == HttpServletRequest.class || parameterType == HttpServletResponse.class){
                paramMapping.put(parameterType.getName(),i);
            }
        }

        // 2、通过Url传递过来的参数
        final Map<String,String[]> parameterMap = request.getParameterMap();


        return null;
    }

}
