package com.nab.greetingclient.opt2;

import com.nab.greetingclient.ClientGreetingController;
import com.nab.greetingclient.Greeting;
import com.nab.greetingclient.opt2.proxy.GreetingServiceProxy;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@NoArgsConstructor
public class ClientGreetingControllerF implements ClientGreetingController {

    @Autowired
    private GreetingServiceProxy serviceProxy;

    @RequestMapping("/greeting/{name}")
    public Greeting greeting(@PathVariable("name") String name) {

        log.info("client greeting service greeting() invoked: " + name);

        Greeting greeting = serviceProxy.greeting(name);

        log.info("greeting found: " + greeting.getContent());

        return greeting;
    }

}
