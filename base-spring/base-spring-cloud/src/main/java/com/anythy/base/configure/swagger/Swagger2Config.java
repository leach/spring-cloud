package com.anythy.base.configure.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2 API配置类
 * @author Leach
 * @date 2018-12-11
 */
@EnableSwagger2
public class Swagger2Config {

    @Autowired
    ConfigVar configVar;

    /**
     * Swagger2 API
     * @author Leach
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(configVar.getSwagger2HandlerBasePackage()))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * Swagger2 API Info
     * @author Leach
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(configVar.getSwagger2ApiTitle())
                .description(configVar.getSwagger2ApiDescription())
                .termsOfServiceUrl(configVar.getSwagger2ApiServiceUrl())
                .version(configVar.getSwagger2ApiVersion())
                .build();
    }
}
