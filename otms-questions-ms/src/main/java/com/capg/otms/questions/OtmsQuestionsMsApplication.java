package com.capg.otms.questions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OtmsQuestionsMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtmsQuestionsMsApplication.class, args);
	}

}
