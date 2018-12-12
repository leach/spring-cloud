package com.anythy.serviceone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author leach
 */

@SpringBootApplication(scanBasePackages = {"com.anythy.base.spring", "com.anythy.serviceone"})
//@EnableEurekaClient
public class ServiceOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceOneApplication.class, args);
    }
}
