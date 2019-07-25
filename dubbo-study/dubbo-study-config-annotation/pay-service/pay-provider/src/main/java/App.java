import org.apache.dubbo.config.ProviderConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

/**
 * @author hzqing
 * @date 2019-07-25 10:14
 */

public class App {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        applicationContext.start();
        System.in.read();
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "com.hzqing")
    @PropertySource("classpath:/dubbo-provider.properties")
    static class ProviderConfiguration{
    }
}
