package com.capg.otms.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class OtmsZuulApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtmsZuulApiGatewayApplication.class, args);
	}

}
