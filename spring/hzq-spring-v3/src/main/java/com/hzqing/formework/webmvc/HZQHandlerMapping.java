package com.hzqing.formework.webmvc;

import lombok.Data;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * @author hzqing
 * @date 2020-01-08 21:27
 */
@Data
public class HZQHandlerMapping {

    /**
     * 请求的Controller
     */
    private Object controller;
    /**
     * 请求方法
     */
    private Method method;
    /**
     * 请求路径
     */
    private Pattern pattern;

    public HZQHandlerMapping(Object controller, Method method, Pattern pattern) {
        this.controller = controller;
        this.method = method;
        this.pattern = pattern;
    }
}
