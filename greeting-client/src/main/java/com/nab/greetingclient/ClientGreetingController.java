package com.nab.greetingclient;

import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class ClientGreetingController {

    protected ClientGreetingService helloWorldService;

    protected Logger logger = Logger.getLogger(ClientGreetingController.class.getName());

    public ClientGreetingController(ClientGreetingService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @RequestMapping("/test2")
    public String test1() {
        return "probando 123";
    }

    @GetMapping("/test2")
    public String test2() {
        return "probando 12345";
    }

    @RequestMapping("/greeting/{name}")
    public Greeting greeting(@PathVariable("name") String name) {

        logger.info("client greeting service greeting() invoked: " + name);

        Greeting greeting = helloWorldService.greeting(name);

        logger.info("greeting found: " + greeting.getContent());

        return greeting;
    }

}
