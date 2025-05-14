package com.jeffrey.SEACH_SERVICE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@FeignClient(name = "POST-SERVICE")
@EnableDiscoveryClient
@EnableScheduling
public class SeachServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeachServiceApplication.class, args);
	}

}
