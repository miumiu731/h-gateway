package com.hperson.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudGatewayApplication {


    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                //basic proxy
                .route(r -> r.path("/baidu").uri("http://baidu.com:80/")
                ).build();
    }
    
//    @Bean
//    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//       return builder.routes()
//        .route(p -> p
//            .path("/secondMode")
//            .filters(f -> f.addRequestHeader("Hello", "World"))
//            .uri("http://demo.hperson.com"))
//        .build();
//    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGatewayApplication.class, args);
    }
}
