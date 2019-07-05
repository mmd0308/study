package com.hzqing.template;

/**
 * @author hzqing
 * @date 2019-07-05 08:15
 */
public class Tests  {
    public static void main(String[] args) {
        DeployProject bookProjectDeploy = new BookProjectDeploy();
        bookProjectDeploy.deploy();

        System.out.println("-------------------------");

        DeployProject wikiProject = new HzqWikiProjectDeploy();
        wikiProject.deploy();
    }
}
