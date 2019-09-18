package com.hzqing.aop.demo1;

/**
 * @author hzqing
 * @date 2019-09-18 09:42
 */
public class UserServiceProxy implements IUserService {

    private IUserService target;

    public UserServiceProxy(IUserService target) {
        this.target = target;
    }

    @Override
    public void insert(User user) {
        long start = System.currentTimeMillis();
        target.insert(user);
        System.out.println("执行用户插入方法花销了：" + (System.currentTimeMillis() - start) + " 毫秒");
    }

    @Override
    public void update(User user) {
        long start = System.currentTimeMillis();
        target.update(user);
        System.out.println("执行用户修改方法花销了：" + (System.currentTimeMillis() - start) + " 毫秒");
    }

    @Override
    public User get(String id) {
        long start = System.currentTimeMillis();
        User user = target.get(id);
        System.out.println("执行用户查询方法花销了：" + (System.currentTimeMillis() - start) + " 毫秒");
        return user;
    }
}
