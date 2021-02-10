package com.giv.giftproject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailService myUserDetailService;

    // @Override
    // public void configure(HttpSecurity http) throws Exception {
    //     http.csrf()
    //             .disable()
    //             .authorizeRequests()
    //             .antMatchers("/resources/**", "/login", "signup")
    //             .authenticated()
    //             .and()
    //             .formLogin()
    //             .loginPage("/login")
    //             .failureUrl("/login?error")
    //             .usernameParameter("user")
    //             .passwordParameter("pass")
    //             .permitAll();
    // }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService);
    }
}