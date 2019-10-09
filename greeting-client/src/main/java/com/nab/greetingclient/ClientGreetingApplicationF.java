package com.nab.greetingclient;

import com.nab.greetingclient.opt2.ClientGreetingControllerF;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients("com.nab.greetingclient.opt2.proxy")
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false) /** Disable component scanner **/
public class ClientGreetingApplicationF {

    public static void main(String[] args) {
        SpringApplication.run(ClientGreetingApplicationF.class, args);
    }

    @Bean
    public ClientGreetingControllerF clientGreetingControllerF() {
        return new ClientGreetingControllerF();
    }

}