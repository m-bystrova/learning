package com.learning.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleConfiguration {

    @Bean
    public SimpleBean myBean() {
        return new SimpleBean();
    }

}