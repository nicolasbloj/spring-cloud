package com.nab.greetingclient.opt2.proxy;

import com.nab.greetingclient.Greeting;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "zuul-server")
public interface GreetingServiceProxy {

    @GetMapping("greeting-service/greeting/{name}")
    Greeting greeting(@PathVariable("name") String name);

}