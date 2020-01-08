package com.hzqing.demo.user.service.impl;

import com.hzqing.demo.user.service.IUserService;
import com.hzqing.formework.annotation.HZQService;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hzqing
 * @date 2020-01-08 20:12
 */
@HZQService
@Slf4j
public class UserServiceImpl implements IUserService {

    @Override
    public String add(String name, String addr) {
        return "新增用户名：" + name + "，新增地址：" + addr;
    }

    @Override
    public String edit(Integer id, String name) {
        return "修改用户ID：" + id + "，修改用户名：" + name;
    }

    @Override
    public String remove(Integer id) {
        return "删除Id: " + id;
    }

    @Override
    public String query(String name) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); String time = sdf.format(new Date());
        String json = "{name:\"" + name + "\",time:\"" + time + "\"}"; log.info("这是在业务方法中打印的:" + json);
        return json;
    }
}
