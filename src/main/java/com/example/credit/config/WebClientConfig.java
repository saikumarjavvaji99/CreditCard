package com.example.credit.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${credit.url}")
    String url;

    @Bean
    public WebClient restClient() {

        return WebClient.builder()
                .baseUrl(url)
                .build();
    }

}
