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

	private static final String template = "Hola, %s! El servicio respondió en el puerto  %s  esta vez...";

	@Autowired
	private Environment environment;

	/**
	 * Say Hello
	 * 
	 * @param name
	 * @return a greeting "Hello" + name + port
	 */	
	@RequestMapping("/greeting/{name}")
    public Greeting greeting(@PathVariable("name") String name) {
		return new Greeting(String.format(template, name, environment.getProperty("local.server.port")));
    }

}
