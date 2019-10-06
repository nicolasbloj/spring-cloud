package com.nab.greetingclient;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * TesGreeting Server. Works as a microservice client, fetching data from the
 * Client Greeting Service. Uses the Discovery Server (Eureka) to find the microservice.
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false) /** Disable component scanner **/
public class ClientGreetingApplication {

	public static final String SERVICE_URL = "http://GREETING-SERVICE";

	public static void main(String[] args) {
		// Tell server to look for web-server.properties or web-server.yml
		//System.setProperty("spring.config.name", "greeting-client");
		SpringApplication.run(ClientGreetingApplication.class, args);
	}
	
	/**
	 * A customized RestTemplate that has the ribbon load balancer build in.
	 * Note that prior to the "Brixton" 
	 * 
	 * @return
	 */
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}


	/**
	 * The Service encapsulates the interaction with the micro-service.
	 * 
	 * @return a new service instance.
	 */
	@Bean
	public ClientGreetingService clientGreetingService() {
		return new ClientGreetingService(SERVICE_URL);
	}

	/**
	 * Create the controller, passing it the {@link ClientGreetingService} to use.
	 * 
	 * @return a new controller instance
	 */
	@Bean
	public ClientGreetingController clientGreetingController() {
		return new ClientGreetingController(clientGreetingService());
	}


}
