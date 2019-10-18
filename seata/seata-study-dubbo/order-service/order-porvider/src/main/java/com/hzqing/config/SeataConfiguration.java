package com.hzqing.config;

import io.seata.spring.annotation.GlobalTransactionScanner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeataConfiguration {

	@Value("${spring.application.name}")
	private String applicationId;


	@Bean
	public GlobalTransactionScanner globalTransactionScanner() {
        GlobalTransactionScanner globalTransactionScanner = new GlobalTransactionScanner(applicationId,
            "my_test_tx_group");
		return globalTransactionScanner;
	}


}
