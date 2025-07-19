package com.example.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
    @Bean
    public RouteLocator dynamicRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("dynamic-contrat", r -> r
                        .path("/dynamic/contrat/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://contrat-service"))
                .route("dynamic-employe", r -> r
                        .path("/dynamic/api/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://employe-service"))
                .build();
    }


}
