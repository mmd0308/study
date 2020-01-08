package com.hzqing.demo.user.service;

/**
 * @author hzqing
 * @date 2020-01-08 20:12
 */
public interface IUserService {
    /**
     * 新增
     */
    public String add(String name, String addr) ;
    /**
     * 修改
     */
    public String edit(Integer id, String name);
    /**
     * 删除
     */
    public String remove(Integer id);

    /**
     * 查询
     */
    public String query(String name);
}
