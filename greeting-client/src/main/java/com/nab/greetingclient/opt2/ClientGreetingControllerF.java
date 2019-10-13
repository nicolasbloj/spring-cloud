package com.nab.greetingclient.opt2;

import com.nab.greetingclient.ClientGreetingController;
import com.nab.greetingclient.Greeting;
import com.nab.greetingclient.opt2.proxy.GreetingServiceProxy;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    @RequestMapping("/")
    public String hello(){
        return "hello world!";
    }

    @HystrixCommand(fallbackMethod = "backGreetingService")
    @RequestMapping("/greeting/{name}")
    public Greeting greeting(@PathVariable("name") String name) {

        log.info("client greeting service greeting() invoked: " + name);

        Greeting greeting = serviceProxy.greeting(name);

        log.info("greeting found: " + greeting.getContent());

        return greeting;
    }

    public Greeting backGreetingService(String name) {
        return Greeting.builder().content("Sorry, Service is Down! I'm greeting-client").build();
    }

    /** podriamos sacar este metodo afuera, podriamos tener una capa de servicio,
     * esamos haciendo uso de hystrix para cuando no responde zuul o falla, podemos loguear esa causa.
     * por otro lado en zuul estamos haciendo lo mismo devolviendo un dummy
     */

}
