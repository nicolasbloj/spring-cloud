
package com.nab.greetingclient.opt1;


import com.nab.greetingclient.Greeting;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;


/**
 * Hide the access to the microservice inside this local service.
 */
@Service
@Log4j2
public class ClientGreetingServiceR {

    @Autowired
    @LoadBalanced
    protected RestTemplate restTemplate;

    protected String serviceUrl;

    public ClientGreetingServiceR(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
    }

    /**
     * The RestTemplate works because it uses a custom request-factory that uses
     * Ribbon to look-up the service to use. This method simply exists to show
     * this.
     */
    @PostConstruct
    public void demoOnly() {
        // Can't do this in the constructor because the RestTemplate injection
        // happens afterwards.
        log.info("The RestTemplate request factory is "
                + restTemplate.getRequestFactory());
    }

    public Greeting greeting(String name) {

        log.info("greeting() invoked: for " + name);

        Greeting greeting = restTemplate.getForObject(serviceUrl + "/greeting/{name}", Greeting.class, name);

        return greeting;

    }


}
