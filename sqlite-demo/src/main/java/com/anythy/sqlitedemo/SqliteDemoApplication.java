package com.anythy.sqlitedemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.anythy.sqlitedemo.mapper")
public class SqliteDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SqliteDemoApplication.class, args);
    }
}
