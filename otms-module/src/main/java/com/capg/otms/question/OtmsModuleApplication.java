package com.capg.otms.question;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class OtmsModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtmsModuleApplication.class, args);
	}

}
