package com.ust.feignn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication
public class FeignnApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignnApplication.class, args);
	}

}
