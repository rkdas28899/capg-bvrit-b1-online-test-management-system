package com.capg.otms.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class OtmsEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtmsEurekaServerApplication.class, args);
	}

}
