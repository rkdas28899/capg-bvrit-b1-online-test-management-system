package com.capg.otms.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OtmsTestMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtmsTestMsApplication.class, args);
	}

}
