package com.hzqing.provider;

import com.hzqing.api.IHelloService;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author hzqing
 * @date 2019-07-26 20:57
 */
//@Service(loadbalance = "random",weight = 5)

//@Service( methods = {
//        @Method(name = "sayHello",loadbalance = "random")
//})
//@Service(loadbalance = "consistenthash") // ConsistentHashLoadBalance 一致性哈希
// @Service(loadbalance = "leastactive") // LeastActiveLoadBalance 最小活跃度
@Service(loadbalance = "roundrobin") // RoundRobinLoadBalance 权重轮询
public class HelloServiceImpl implements IHelloService {

    @Override
    public String sayHello() {
        return "现在调用的hello-service提供的服务";
    }
}
