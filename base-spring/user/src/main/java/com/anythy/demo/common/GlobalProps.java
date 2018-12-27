package com.anythy.demo.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * 配置参数
 * @author Leach
 */
@Getter
@Setter
@Configuration
@RefreshScope
public class GlobalProps {

    /**
     * auth server配置的resource id
     */
    @Value("${resource.id:spring-boot-application}")
    private String resourceId;

    /**
     * token过期时间
     * 默认3600s(秒)
     */
    @Value("${token.validity_period:3600}")
    private int tokenValidityPeriod;
}
