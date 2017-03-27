package com.wpf.springsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

/**
 * Created by wenpengfei on 2017/3/27.
 */
@EnableWebSecurity
@Configuration
@Component
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        UserDetails user = User.withUsername("user").password("auth").roles("USER").build();
        manager.createUser(user);
        UserDetails admin = User.withUsername("admin").password("auth").roles("ADMIN").build();
        manager.createUser(admin);
        return manager;
    }

    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/index").permitAll()
                .antMatchers("/user").hasRole("USER")
                .antMatchers("/admin").hasRole("amdin")
                .anyRequest().authenticated().and().formLogin();
    }
}
