package com.lwg.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FegionConfig {

    @Bean
    Logger.Level feiginLoggerLevel(){
        return Logger.Level.FULL;
    }
}
