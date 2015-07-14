package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.example.web")
@Import({ ExtendedSecurityConfig.class })
//@ImportResource(value = "classpath*:security-beans.xml")
public class AppMvcConfig {
}
