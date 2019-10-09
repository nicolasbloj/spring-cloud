package com.nab.greetingclient;

import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ClientGreetingController {

    Greeting greeting(String name);

}