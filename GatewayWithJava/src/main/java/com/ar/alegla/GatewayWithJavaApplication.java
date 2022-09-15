package com.ar.alegla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GatewayWithJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayWithJavaApplication.class, args);
	}

}
