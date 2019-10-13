package com.nab.gateway.config;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class GreetingFallbackConfig {

    private static final String GREETING_DUMMY_RESPONSE = "{\"content\":\"Sorry, Service is Down! I'm zuul-server\"}";

    @Bean
    public FallbackProvider zuulFallbackProvider() {
        return new FallbackProvider() {

            @Override
            public String getRoute() {
                // Might be confusing: it's the serviceId property and not the route
                return "greeting-service";
            }

            @Override
            public ClientHttpResponse fallbackResponse(String route, Throwable cause) {

                return new ClientHttpResponse() {
                    @Override
                    public HttpStatus getStatusCode() throws IOException {
                        return HttpStatus.OK;
                    }

                    @Override
                    public int getRawStatusCode() throws IOException {
                        return HttpStatus.OK.value();
                    }

                    @Override
                    public String getStatusText() throws IOException {
                        return HttpStatus.OK.toString();
                    }

                    @Override
                    public void close() {
                    }

                    @Override
                    public InputStream getBody() throws IOException {
                        return new ByteArrayInputStream(GREETING_DUMMY_RESPONSE.getBytes());
                    }

                    @Override
                    public HttpHeaders getHeaders() {
                        HttpHeaders headers = new HttpHeaders();
                        headers.setContentType(MediaType.APPLICATION_JSON);
                        return headers;
                    }


                };
            }

        };
    }
}