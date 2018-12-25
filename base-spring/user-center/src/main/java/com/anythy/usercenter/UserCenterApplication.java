package com.anythy.usercenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Leach
 */
@SpringBootApplication(scanBasePackages = {"com.anythy.base.spring", "com.anythy.usercenter"})
public class UserCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCenterApplication.class, args);
    }

}

