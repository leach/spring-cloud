package com.anythy.base.spring;

import com.anythy.base.spring.configure.ConfigVar;
import com.anythy.base.spring.configure.Swagger2Config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Spring-boot自动配置
 * @author Leach
 * @date 2018-12-11
 */
@Configuration
@Import({ConfigVar.class, Swagger2Config.class})
public class SpringBootAutoConfig {
}
