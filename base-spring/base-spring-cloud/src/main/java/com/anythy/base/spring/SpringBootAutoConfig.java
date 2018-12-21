package com.anythy.base.spring;

import com.anythy.base.configure.apiversion.WebMvcRegistrationsConfig;
import com.anythy.base.configure.common.CommonExceptionHandler;
import com.anythy.base.configure.swagger.ConfigVar;
import com.anythy.base.configure.swagger.Swagger2Config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Spring-boot自动配置
 * @author Leach
 * @date 2018-12-11
 */
@Configuration
@Import({ConfigVar.class, Swagger2Config.class, WebMvcRegistrationsConfig.class, CommonExceptionHandler.class})
public class SpringBootAutoConfig {
}
