package com.hzqing.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author hzqing
 * @date 2019-08-05 14:31
 */
@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("admin")).roles("ADMIN");
    }
}
