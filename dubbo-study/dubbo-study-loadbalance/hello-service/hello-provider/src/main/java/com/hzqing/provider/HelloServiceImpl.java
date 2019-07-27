package com.hzqing.provider;

import com.hzqing.api.IHelloService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author hzqing
 * @date 2019-07-26 20:57
 */
@Service
public class HelloServiceImpl implements IHelloService {

    @Value("${dubbo.protocol.port}")
    private String port;

    @Value("${dubbo.provider.weight}")
    private String weight;

    @Override
    public String sayHello() {
        return "现在调用的hello-service提供的dubbo协议端口是:  " + port + "服务权重是: " + weight;
    }
}
