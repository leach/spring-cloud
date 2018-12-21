package com.anythy.serviceone.controller;

import com.anythy.base.configure.apiversion.annotation.ApiVersion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * demo
 * @author Leach
 */
@ApiVersion(1)
@Api(value = "Version Demo controller", description = "版本控制接口测试")
@RestController
@RequestMapping("/{version}/versionDemo")
public class VersionDemoController {

    @ApiImplicitParam(name = "version", value = "版本号", required = true, defaultValue = "V1",dataType = "String", paramType = "path")
    @GetMapping("/test")
    public String test(){
        return "VERSION 1";
    }

}
