package com.capg.otms.updateanddeletetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class OtmsUpdateAndDeleteTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtmsUpdateAndDeleteTestApplication.class, args);
	}
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
