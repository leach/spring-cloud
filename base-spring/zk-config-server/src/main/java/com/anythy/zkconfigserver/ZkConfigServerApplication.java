package com.anythy.zkconfigserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Leach
 */
@SpringBootApplication(scanBasePackages = {"com.anythy.zkconfigserver", "com.anythy.base.spring"})
@MapperScan(basePackages = "com.anythy.zkconfigserver.mapper")
public class ZkConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZkConfigServerApplication.class, args);
    }

}

