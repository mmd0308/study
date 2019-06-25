package com.hzqing;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;

/**
 * @author hzqing
 * @date 2019-06-25 11:06
 */
public class TestToString {

    @Test
    public void test(){
        Jedis jedis = new Jedis("localhost",6379);
        // 写入 domain=www.hzqing.com 到Redis
        jedis.set("domain","www.hzqing.com");
        //  获取键为domain的值
        System.out.println("domain = " + jedis.get("domain"));

        // 写入一个暂存10秒的数据
        jedis.setex("name",10,"zhangsan");

        // 获取旧的值，设置新的值
        System.out.println("键为name的旧值是： " + jedis.getSet("name","lisi"));
        System.out.println("键为name的新值是： " + jedis.get("name"));

        // 批量写入键值(key1,value1,key2,value2 ...)
        jedis.mset("name1","zhangsan","name2","lisi");
        // 批量获取值
        List<String> mget = jedis.mget("name1", "name2");
        System.out.println("批量获取的结果是： " + mget.toString());

    }
}
