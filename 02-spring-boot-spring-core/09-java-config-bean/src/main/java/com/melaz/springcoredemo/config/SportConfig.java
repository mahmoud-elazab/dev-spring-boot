package com.melaz.springcoredemo.config;

import com.melaz.springcoredemo.common.Coach;
import com.melaz.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
