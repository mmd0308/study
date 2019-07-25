package com.hzqing;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;

/**
 * @author hzqing
 * @date 2019-07-25 09:25
 */
public class App {
    public static void main(String[] args) {
        ApplicationConfig applicationConfig = new ApplicationConfig("order-service");

        RegistryConfig registryConfig = new RegistryConfig("zookeeper://localhost:2181");

        // 应用远程服务
        ReferenceConfig<IPayService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setVersion("1.0.0");
        referenceConfig.setInterface(IPayService.class);

        // 使用PayService
        IPayService payService = referenceConfig.get();
        String pay = payService.pay("订单服务调用支付服务");
        System.out.println(pay);
    }
}
