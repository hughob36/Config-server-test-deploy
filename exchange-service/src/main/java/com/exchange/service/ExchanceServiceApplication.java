package com.exchange.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ExchanceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchanceServiceApplication.class, args);
	}

}
