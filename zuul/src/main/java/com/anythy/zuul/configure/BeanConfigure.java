package com.anythy.zuul.configure;

import com.anythy.zuul.filter.TokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigure {

    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }
}
