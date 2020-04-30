package com.capg.otms.user;

import org.hibernate.annotations.Loader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OtmsUserApplication {

	public static void main(String[] args) {
		
		
		SpringApplication.run(OtmsUserApplication.class, args);
	}
		@Bean
		
		public RestTemplate getRestTemplate() {
			return new RestTemplate();
		
	}

}
