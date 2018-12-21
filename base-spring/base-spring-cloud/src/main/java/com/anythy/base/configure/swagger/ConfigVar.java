package com.anythy.base.configure.swagger;

import org.springframework.beans.factory.annotation.Value;

/**
 * 基本配置
 * @author Leach
 * @date 2018-12-11
 */
public class ConfigVar {

    /**
     * swagger2 handler包路径
     */
    @Value("${swagger2.handler.basePackage:com.anythy}")
    private String swagger2HandlerBasePackage;

    /**
     * swagger2 API Title
     */
    @Value("${swagger2.api.title:Swagger2-API}")
    private String swagger2ApiTitle;

    /**
     * swagger2 API description
     */
    @Value("${swagger2.api.description:}")
    private String swagger2ApiDescription;

    /**
     * swagger2 API serviceUrl
     */
    @Value("${swagger2.api.serviceUrl:http://www.anythy.com}")
    private String swagger2ApiServiceUrl;

    /**
     * swagger2 API version
     */
    @Value("${swagger2.api.version:1.0}")
    private String swagger2ApiVersion;


    public String getSwagger2HandlerBasePackage() {
        return swagger2HandlerBasePackage;
    }

    public void setSwagger2HandlerBasePackage(String swagger2HandlerBasePackage) {
        this.swagger2HandlerBasePackage = swagger2HandlerBasePackage;
    }

    public String getSwagger2ApiTitle() {
        return swagger2ApiTitle;
    }

    public void setSwagger2ApiTitle(String swagger2ApiTitle) {
        this.swagger2ApiTitle = swagger2ApiTitle;
    }

    public String getSwagger2ApiDescription() {
        return swagger2ApiDescription;
    }

    public void setSwagger2ApiDescription(String swagger2ApiDescription) {
        this.swagger2ApiDescription = swagger2ApiDescription;
    }

    public String getSwagger2ApiServiceUrl() {
        return swagger2ApiServiceUrl;
    }

    public void setSwagger2ApiServiceUrl(String swagger2ApiServiceUrl) {
        this.swagger2ApiServiceUrl = swagger2ApiServiceUrl;
    }

    public String getSwagger2ApiVersion() {
        return swagger2ApiVersion;
    }

    public void setSwagger2ApiVersion(String swagger2ApiVersion) {
        this.swagger2ApiVersion = swagger2ApiVersion;
    }
}
