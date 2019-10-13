package com.nab.gateway.config;

import com.netflix.zuul.ZuulFilter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@NoArgsConstructor
public class ZuulConfiguration {

    @Bean
    public ZuulFilter buildZuulFilter(){
        return new MyZuulFilter();
    }

}