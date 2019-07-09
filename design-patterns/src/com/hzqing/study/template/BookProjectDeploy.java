package com.hzqing.study.template;

/**
 * @author hzqing
 * @date 2019-07-05 08:12
 */
public class BookProjectDeploy extends DeployProject {
    @Override
    protected void releaseFormal() {
        System.out.println("图书管理系统发布正式系统");
    }

    @Override
    protected void releaseTests() {
        System.out.println("图书管理系统发布测试系统");
    }

    @Override
    protected void structure() {
        System.out.println("maven编译构建");
    }
}
