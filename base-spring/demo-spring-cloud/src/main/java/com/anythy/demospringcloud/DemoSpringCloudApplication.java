package com.anythy.demospringcloud;

import com.anythy.base.spring.context.SpringContextUtils;
import com.anythy.demospringcloud.config.ConfigVar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.anythy.demospringcloud", "com.anythy.base.spring.context"})
public class DemoSpringCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringCloudApplication.class, args);
    }
}
