package com.test.annotation.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfiguration {

	@Bean
	public MyDaoBean getMyDaoBean() {
		return new MyDaoBean();
	}

	@Bean(name = { "getMyFileSystemBean", "MyFileSystemBean" }, initMethod = "init", destroyMethod = "destroy")
	public MyFileSystemBean getMyFileSystemBean() {
		return new MyFileSystemBean();
	}
}
