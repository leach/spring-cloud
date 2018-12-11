package com.anythy.serviceone.configure;

import com.anythy.serviceone.service.DemoService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author leach
 */
@Configuration
@Import(DemoService.class)
public class BaseConfig {

}
