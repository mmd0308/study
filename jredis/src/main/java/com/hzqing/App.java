package com.hzqing;

import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        Jedis jedis = new Jedis("localhost",6379);
        // 查看Redis服务器信息
        System.out.println(jedis.info());
    }
}
