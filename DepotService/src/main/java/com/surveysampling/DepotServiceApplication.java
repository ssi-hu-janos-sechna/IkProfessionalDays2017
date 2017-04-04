package com.surveysampling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DepotServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepotServiceApplication.class, args);
	}
}
