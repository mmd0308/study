package com.hzqing.seata.pay.payprovider.config;

import com.zaxxer.hikari.HikariDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import io.seata.spring.annotation.GlobalTransactionScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author: heshouyou
 * @Description  seata global configuration
 * @Date Created in 2019/1/24 10:28
 */
@Configuration
public class SeataAutoConfig {
    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Bean
    HikariDataSource hikariDataSource(){
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setUsername(dataSourceProperties.getUsername());
        hikariDataSource.setPassword(dataSourceProperties.getPassword());
        hikariDataSource.setJdbcUrl(dataSourceProperties.getUrl());
        hikariDataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        return hikariDataSource;
    }

    @Bean
    JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(hikariDataSource());
    }

    @Bean
    public DataSourceProxy dataSourceProxy(HikariDataSource hikariDataSource){
        return new DataSourceProxy(hikariDataSource);
    }


    @Bean
    public GlobalTransactionScanner globalTransactionScanner(){
        return new GlobalTransactionScanner("dubbo-gts-pay", "my_test_tx_group");
    }
}
