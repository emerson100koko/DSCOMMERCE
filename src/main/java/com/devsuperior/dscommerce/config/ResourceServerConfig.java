package com.devsuperior.dscommerce.config;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import java.util.Arrays;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    private Environment env;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        // H2 frames
        if (Arrays.asList(env.getClass()).contains("test")) {
            http.headers().frameOptions().disable();
        }
        http.authorizeRequests().anyRequest().permitAll();
    }
}
