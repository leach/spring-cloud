package com.anythy.demo.configure;

import com.anythy.demo.entity.UserVO;
import com.anythy.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Web Security配置
 * @author Leach
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;

    /**
     *
     * @param builder
     * @throws Exception
     */
    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll().anyRequest().authenticated().and()
                .httpBasic().and().csrf().disable();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean("userDetailsService")
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetailsService userDetailsService = (username) -> {
            UserVO userVO = userService.findUser(username);
            if (userVO != null) {
                User user = new User(username, userVO.getPassword(), AuthorityUtils.createAuthorityList(userVO.getRoles()));
                return user;
            }
            throw new UsernameNotFoundException("用户不存在");
        };
        return userDetailsService;
    }
}
