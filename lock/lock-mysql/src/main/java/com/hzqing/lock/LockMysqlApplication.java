package com.hzqing.lock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hzqing.lock.mapper")
public class LockMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(LockMysqlApplication.class, args);
	}

}
