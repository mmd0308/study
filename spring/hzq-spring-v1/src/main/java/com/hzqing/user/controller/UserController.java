package com.hzqing.user.controller;

import com.hzqing.annoation.HZQAutowired;
import com.hzqing.annoation.HZQController;
import com.hzqing.annoation.HZQRequestMapping;
import com.hzqing.annoation.HZQRequestParam;
import com.hzqing.user.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hzqing
 * @date 2020-01-04 14:26
 */
@HZQController
@HZQRequestMapping("/user")
public class UserController {

    @HZQAutowired
    private IUserService userService;

    @HZQRequestMapping("/get")
    public void get(HttpServletRequest request, HttpServletResponse response, @HZQRequestParam("name")String name){
        String res = userService.get(name);
        try {
            response.getWriter().write(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
