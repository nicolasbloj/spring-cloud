package com.nab.greeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * Run as a micro-service, registering with the Discovery Server (Eureka)
 */
@SpringBootApplication
//@EnableAutoConfiguration // ? defines this as a Spring Boot application
@EnableDiscoveryClient
public class GreetingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingApplication.class, args);
	}
}

/**@EnableDiscoveryClient
 * This enables service registration and discovery.
 * In this case, this process registers itself with the discovery-server service using its application name
 */
