package com.hzqing.client;

import com.hzqing.api.IHelloService;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hzqing
 * @date 2019-07-26 21:32
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloTest {

    //@Reference(loadbalance = "random")  // RandomLoadBalance 权重负载
//    @Reference(methods = {
//            @Method( name = "sayHello",loadbalance = "random")
//    })
    //@Reference(loadbalance = "consistenthash") // ConsistentHashLoadBalance 一致性哈希
    // @Reference(loadbalance = "leastactive") // LeastActiveLoadBalance 最小活跃度
    @Reference(loadbalance = "roundrobin") // RoundRobinLoadBalance 权重轮询
    private IHelloService helloService;

    @Test
    public void hello(){
        String res = helloService.sayHello();
        System.out.println(res);
    }
}
