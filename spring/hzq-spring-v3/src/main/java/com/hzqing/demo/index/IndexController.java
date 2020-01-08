package com.hzqing.demo.index;

import com.hzqing.demo.user.service.IUserService;
import com.hzqing.formework.annotation.HZQAutowired;
import com.hzqing.formework.annotation.HZQController;
import com.hzqing.formework.annotation.HZQRequestMapping;
import com.hzqing.formework.annotation.HZQRequestParam;
import com.hzqing.formework.webmvc.HZQModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hzqing
 * @date 2020-01-08 21:38
 */
@HZQController
@HZQRequestMapping("/index")
public class IndexController {

    @HZQAutowired
    private IUserService userService;

    @HZQRequestMapping("/first.html")
    public HZQModelAndView query(@HZQRequestParam("teacher") String teacher){
        String result = userService.query(teacher);
        Map<String,Object> model = new HashMap<String,Object>();
        model.put("teacher", teacher);
        model.put("data", result);
        model.put("token", "123456");
        return null;
    }
}
