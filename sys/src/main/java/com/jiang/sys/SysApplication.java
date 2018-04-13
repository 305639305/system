package com.jiang.sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SysApplication {

	public static void main(String[] args) {
		SpringApplication.run(SysApplication.class, args);

	}
}
