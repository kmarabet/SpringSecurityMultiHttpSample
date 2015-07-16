package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, proxyTargetClass = true)
public class ExtendedSecurityConfig {

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.inMemoryAuthentication()
                .withUser("user").password("pass").roles("USER")
        .and()
                .withUser("admin").password("pass").roles("ADMIN");
    }

    @Configuration
    @Order(1)
    public static class ApiWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()//.anyRequest().permitAll()
                    .antMatchers("/api/**")
                    .hasRole("ADMIN")
                    .and()
                    .httpBasic();
        }
    }

    @Configuration
    //@Order(1)
    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        @Override
        public void configure(WebSecurity web) throws Exception {
            web
                    .ignoring()
                    .antMatchers("/resources/**");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    //.anyRequest().authenticated()
                    .antMatchers("/landing").access("hasRole('USER')")
                    .and()
                    .formLogin().loginPage("/login").failureUrl("/login?error")
                    .loginProcessingUrl("/j_spring_security_check")
                    .usernameParameter("username").passwordParameter("password")
                    .and()
                    .logout().logoutSuccessUrl("/login?logout").invalidateHttpSession(true)
                    .and()
                    .csrf().disable();
        }
    }

}
