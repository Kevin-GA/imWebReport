package com.fang.bigdata.metadata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.fang.bigdata")
@MapperScan("com.fang.bigdata.metadata.dao")
public class ImWebReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImWebReportApplication.class, args);
	}
}
