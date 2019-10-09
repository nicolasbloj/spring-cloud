package com.nab.greetingclient.opt1;

import com.nab.greetingclient.ClientGreetingController;
import com.nab.greetingclient.Greeting;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Log4j2
public class ClientGreetingControllerR implements ClientGreetingController {

    protected ClientGreetingServiceR greetingServiceR;

    @RequestMapping("/test")
    public String test() {
        return "Testing 123";
    }

    @RequestMapping("/greeting/{name}")
    public Greeting greeting(@PathVariable("name") String name) {

        log.info("client greeting service greeting() invoked: " + name);

        Greeting greeting = greetingServiceR.greeting(name);

        log.info("greeting found: " + greeting.getContent());

        return greeting;
    }

}
