package com.anythy.demospringcloud.controller;

import com.anythy.base.spring.context.SpringContextUtils;
import com.anythy.demospringcloud.config.ConfigVar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Leach
 */
@RestController
@RequestMapping("/zk")
public class ZkController {
    @Autowired
    private Environment environment;

    @Autowired
    ConfigVar configVar;

    @GetMapping("/test")
    public String test(){
        String name = environment.getProperty("name");
        System.out.println(name);
        System.out.println(configVar.getName());
        System.out.println(SpringContextUtils.getBean(ConfigVar.class).getName());
        return name;
    }
}
