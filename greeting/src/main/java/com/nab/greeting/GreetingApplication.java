package com.nab.greeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;


/**
 * Run as a micro-service, registering with the Discovery Server (Eureka)
 */
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
@EnableHystrix
@EnableCircuitBreaker
public class GreetingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingApplication.class, args);
	}
}

/**@EnableDiscoveryClient
 * This enables service registration and discovery.
 * In this case, this process registers itself with the discovery-server service using its application name
 */
