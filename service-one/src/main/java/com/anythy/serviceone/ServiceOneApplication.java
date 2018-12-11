package com.anythy.serviceone;

import com.anythy.base.spring.context.SpringContextUtils;
import com.anythy.serviceone.service.DemoService;
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
        SpringContextUtils.getBean(DemoService.class).doSomething();
    }
}
