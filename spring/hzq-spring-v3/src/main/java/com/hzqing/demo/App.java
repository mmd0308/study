package com.hzqing.demo;

import com.hzqing.demo.user.controller.UserController;
import com.hzqing.formework.context.HZQApplicationContext;

/**
 * @author hzqing
 * @date 2020-01-08 15:34
 */
public class App {
    public static void main(String[] args) {
        HZQApplicationContext applicationContext = new HZQApplicationContext("application.properties");
        UserController userController = (UserController) applicationContext.getBean("userController");
        userController.say();
    }
}
