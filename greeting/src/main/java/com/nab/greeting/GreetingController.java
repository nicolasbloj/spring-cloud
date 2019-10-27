package com.nab.greeting;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * A RESTFul controller for accessing greeting.
 */
@RestController
@Log4j2
public class GreetingController {

	private static final String template = "Hola, %s!";

	@Autowired
	private Environment environment;

	//@Value("${server.port}")
	//private String port;

	/**
	 * Say Hello + Port + Extra property
	 * 
	 * @param name
	 * @return a greeting "Hello" + name +
	 */	
	@RequestMapping("/greeting/{name}")
    public Greeting greeting(@PathVariable("name") String name) {
		return Greeting.builder()
				.content(String.format(template, name))
				.port(environment.getProperty("local.server.port"))
				.property(environment.getProperty("sample.property"))
				.build();
    }

}
