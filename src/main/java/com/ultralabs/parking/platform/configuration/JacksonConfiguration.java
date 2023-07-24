package com.ultralabs.parking.platform.configuration;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfiguration {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder -> builder
                .simpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS'Z'")
                .timeZone("UTC");
    }
}
