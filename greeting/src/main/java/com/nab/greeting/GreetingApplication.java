package com.nab.greeting;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * Run as a micro-service, registering with the Discovery Server (Eureka)
 *
 */

@EnableAutoConfiguration //defines this as a Spring Boot application
@EnableDiscoveryClient //this enables service registration and discovery. In this case, this process registers itself with the discovery-server service using its application name 
@SpringBootApplication
public class GreetingApplication {


	protected Logger logger = Logger.getLogger(GreetingApplication.class.getName());

	public static void main(String[] args) {
		// Tell server to look for greeting-server.yml
		//System.setProperty("spring.config.name", "greeting-server");
		SpringApplication.run(GreetingApplication.class, args);
	}
}


