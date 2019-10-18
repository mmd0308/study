package com.hzqing;

import com.zaxxer.hikari.HikariDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author hzqing
 * @date 2019-08-05 22:15
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableTransactionManagement
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }

    @Bean(destroyMethod = "close", initMethod = "init")
    @ConfigurationProperties(prefix = "spring.datasource")
    public HikariDataSource hikariDataSource() {
        return new HikariDataSource();
    }


    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary
    @Bean("dataSource")
    public DataSource dataSource(HikariDataSource hikariDataSource) {
        DataSourceProxy dataSourceProxy = new DataSourceProxy(hikariDataSource);
        return dataSourceProxy;
    }


}
