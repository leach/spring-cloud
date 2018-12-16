package com.anythy.zkconfigserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalProps {

    @Value("${zk_session_timeout:3000}")
    private Integer zk_session_timeout;
}
