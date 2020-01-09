package com.hzqing.demo.user.controller;

import com.hzqing.demo.user.service.IUserService;
import com.hzqing.formework.annotation.HZQAutowired;
import com.hzqing.formework.annotation.HZQController;
import com.hzqing.formework.annotation.HZQRequestMapping;
import com.hzqing.formework.annotation.HZQRequestParam;
import com.hzqing.formework.webmvc.HZQModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hzqing
 * @date 2020-01-08 20:11
 */
@HZQController
@HZQRequestMapping("/user")
public class UserController {

    @HZQAutowired
    private IUserService userService;

    @HZQRequestMapping("/query.json")
    public HZQModelAndView query(HttpServletRequest request, HttpServletResponse response,
                                @HZQRequestParam("name") String name){ String result = userService.query(name);
        return out(response,result); }
    @HZQRequestMapping("/add*.json")
    public HZQModelAndView add(HttpServletRequest request,HttpServletResponse response,
                              @HZQRequestParam("name") String name,@HZQRequestParam("addr") String addr){ String result = userService.add(name,addr);
        return out(response,result);
    }
    @HZQRequestMapping("/remove.json")
    public HZQModelAndView remove(HttpServletRequest request, HttpServletResponse response,
                                 @HZQRequestParam("id") Integer id){ String result = userService.remove(id); return out(response,result);
    }
    @HZQRequestMapping("/edit.json")
    public HZQModelAndView edit(HttpServletRequest request, HttpServletResponse response, @HZQRequestParam("id") Integer id,
                                @HZQRequestParam("name") String name){
        String result = userService.edit(id,name);
        return out(response,result);
    }

    private HZQModelAndView out(HttpServletResponse resp,String str){
        try {
            resp.getWriter().write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void say() {
        System.out.println("UserController.say");
    }
}
