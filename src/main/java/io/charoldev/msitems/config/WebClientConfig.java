package io.charoldev.msitems.config;

import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;

@Configuration
public class WebClientConfig {

    @Bean
    @LoadBalanced
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder()
                .baseUrl("http://ms-products/api/products");
    }

    @Bean
    public WebClientCustomizer webClientCustomizer() {
        return builder -> builder.defaultHeaders((HttpHeaders headers) ->
                headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON))
        );
    }
}