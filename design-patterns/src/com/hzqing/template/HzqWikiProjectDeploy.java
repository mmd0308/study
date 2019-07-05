package com.hzqing.template;

/**
 * @author hzqing
 * @date 2019-07-05 08:14
 */
public class HzqWikiProjectDeploy extends DeployProject {
    @Override
    protected void releaseFormal() {
        System.out.println("wiki 项目发布正式系统");
    }

    @Override
    protected void releaseTests() {
        System.out.println("wiki 发布测试系统");
    }

    @Override
    protected void structure() {
        System.out.println("wiki 项目编译构建");
    }
}
