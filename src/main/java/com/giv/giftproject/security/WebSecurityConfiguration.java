package com.giv.giftproject.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/resources/**", "/login", "signup")
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .usernameParameter("user")
                .passwordParameter("pass")
                .permitAll();
    }

}