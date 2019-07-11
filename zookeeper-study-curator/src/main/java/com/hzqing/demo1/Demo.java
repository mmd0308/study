package com.hzqing.demo1;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.zookeeper.CreateMode;

import java.util.List;

/**
 * @author hzqing
 * @date 2019-07-11 16:09
 */
public class Demo {
    static CuratorFramework curatorFramework = null;
    static {
            curatorFramework = CuratorFrameworkFactory.builder()
                    .connectString("localhost:2181")
                    .sessionTimeoutMs(5000)
                    .retryPolicy(new RetryOneTime(1000))
                    .namespace("curator")
                    .build();
            curatorFramework.start();
    }

    public static void main(String[] args) throws Exception {
//        create();
//        updateNodes();
//        getNodes();
        deleteNodes();
    }

    private static void deleteNodes() throws Exception {

        curatorFramework.delete().forPath("/hzqing");
    }

    private static void updateNodes() throws Exception {
        curatorFramework.setData().forPath("/hzqing","hzqing.com".getBytes());
    }

    /**
     * 获取节点
     * @throws Exception
     */
    private static void getNodes() throws Exception {

        List<String> list = curatorFramework.getChildren().forPath("/");
        list.forEach(System.out::println);
    }

    /**
     * 创建节点
     * @throws Exception
     */
    private static void create() throws Exception {
        // 创建持久化节点
        curatorFramework.create().withMode(CreateMode.PERSISTENT).forPath("/hzqing","hzqing-data".getBytes());
    }
}
