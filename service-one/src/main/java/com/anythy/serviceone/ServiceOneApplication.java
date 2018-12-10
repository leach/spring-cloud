package com.anythy.serviceone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;

/**
 * @author leach
 */

@SpringBootApplication
@EnableEurekaClient
public class ServiceOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceOneApplication.class, args);

    }
}
