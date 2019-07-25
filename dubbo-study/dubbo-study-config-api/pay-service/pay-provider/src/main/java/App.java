import com.hzqing.IPayService;
import com.hzqing.PayServiceImpl;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.container.Main;

import java.io.IOException;

/**
 * @author hzqing
 * @date 2019-07-25 09:11
 */
public class App {
    public static void main(String[] args) throws IOException {
        // 服务实现
        IPayService payService = new PayServiceImpl();

        // 配置当前应用
        ApplicationConfig applicationConfig = new ApplicationConfig();
        // 设置服务名称
        applicationConfig.setName("pay-service");

        // 设置注册中心
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://localhost:2181");

        // 设置协议
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);

        // 服务提供者暴露服务
        ServiceConfig<IPayService> config = new ServiceConfig<IPayService>();
        config.setApplication(applicationConfig);
        config.setRegistry(registryConfig);
        config.setProtocol(protocolConfig);
        config.setInterface(IPayService.class);
        config.setRef(payService);
        config.setVersion("1.0.0");
        // 暴露注册服务
        config.export();


        // 保持进程不关闭
        System.in.read();
    }
}
