package com.anythy.serviceone.controller;

import com.anythy.base.spring.apiversion.annotation.ApiVersion;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

/**
 * demo
 * @author Leach
 */
@ApiVersion(1)
@RestController
@RequestMapping("/{version}/versionDemo")
@Api(value = "version demo controller", description = "测试")
public class VersionDemoController {

    @GetMapping("/test1")
    public String test1(){
        return "version 1";
    }

    @GetMapping("/test2")
    public String test2(){
        return "version 2";
    }

}
