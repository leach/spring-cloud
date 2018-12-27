package com.anythy.usercenter.configure;

import com.anythy.usercenter.common.GlobalProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

import static com.sun.corba.se.spi.logging.CORBALogDomains.OA;

/**
 * 资源服务配置
 * @author Leach
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    @Autowired
    private GlobalProps globalProps;

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Autowired
    private TokenStore tokenStore;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(globalProps.getResourceId());
        resources.tokenServices(defaultTokenServices());
        super.configure(resources);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.requestMatcher(
                (httpServletRequest) -> {
                    String auth = httpServletRequest.getHeader("Authorization");
                    boolean hasOauth2Token = (auth != null) && auth.startsWith("bearer");
                    boolean hasAccessToken = httpServletRequest.getParameter("access_token") != null;
                    return hasOauth2Token || hasAccessToken;
                }
        ).authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll();
    }

    /*public static class OAuthRequestedMatcher implements RequestMatcher{

        @Override
        public boolean matches(HttpServletRequest httpServletRequest) {
            String auth = httpServletRequest.getHeader("Authorization");
            boolean hasOauth2Token = (auth != null) && auth.startsWith("bearer");
            boolean hasAccessToken = httpServletRequest.getParameter("access_token") != null;
            return hasOauth2Token || hasAccessToken;
        }
    }*/

    @Bean
    public ResourceServerTokenServices defaultTokenServices(){
        final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenEnhancer(jwtAccessTokenConverter);
        defaultTokenServices.setTokenStore(tokenStore);
        return defaultTokenServices;
    }
}
