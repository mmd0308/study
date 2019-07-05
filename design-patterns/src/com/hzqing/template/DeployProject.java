package com.hzqing.template;

/**
 * @author hzqing
 * @date 2019-07-05 08:06
 */
public abstract class DeployProject {

    public final void deploy(){
        // 开发人员提交代码
        submit();

        // maven 构建
        structure();

        // 发布测试系统
        releaseTests();

        // 发布正式系统
        releaseFormal();
    }

    /**
     * 发布正式系统
     */
    protected abstract void releaseFormal();

    /**
     * 发布测试系统
     */
    protected abstract void releaseTests();


    /**
     * maven 构建项目
     */
    protected abstract void structure();

    /**
     * 开发人员提交待阿妹
     */
    protected  void submit(){
        System.out.println("开发人员提交代码...");
    }
}
