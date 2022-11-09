//package com.example.reservasibioskop.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
////
////    @Override
////    protected void configure(HttpSecurity http) throws Exception{
////        http
////                .httpBasic()
////                .and()
////                .authorizeRequests()
////                .antMatchers("/user/**").hasAnyRole("Admin")
////                .anyRequest().permitAll()
////                .and()
////                .csrf().disable()
////                .formLogin().disable();
////    }
////
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
////        auth.inMemoryAuthentication()
////                .withUser("user").password("{noop}1234").roles("User")
////                .and()
////                .withUser("Admin").password("{noop}1234").roles("User", "Admin");
////    }
//}
