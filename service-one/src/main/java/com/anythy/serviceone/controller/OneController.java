package com.anythy.serviceone.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leach
 */
@RestController
@RequestMapping("index")
@Api(value = "One controller", description = "测试")
public class OneController {

    @Autowired
    DiscoveryClient discoveryClient;

    @ApiOperation(value = "导入任务")
    @RequestMapping("test")
    public String test(){
        return "test/one";
    }
}
