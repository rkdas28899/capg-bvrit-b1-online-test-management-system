package com.capg.otms.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class OtmsUserApplication {

	public static void main(String[] args) {
		
		
		SpringApplication.run(OtmsUserApplication.class, args);
	}
		@Bean
		@LoadBalanced
		public RestTemplate getRestTemplate() {
			return new RestTemplate();
		
	}

}
