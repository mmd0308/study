package com.hzqing.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author hzqing
 * @date 2019-08-05 14:27
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                // 基于内存设置
                .inMemory()
                // client_id
                .withClient("client")
                // client_secret
                .secret(passwordEncoder.encode("secret"))
                // 授权类型
                .authorizedGrantTypes("authorization_code")
                // 授权范围，用来限制客户端的访问范围，如果为空（默认）的话，那么客户端拥有全部的访问范围
                .scopes("app")
                // 回掉地址
                .redirectUris("http://localhost:8080");
    }
}
