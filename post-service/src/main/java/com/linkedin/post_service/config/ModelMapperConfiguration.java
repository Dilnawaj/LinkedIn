package com.linkedin.post_service.config;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {

    @Bean
    ModelMapper modelMapperConfig()
    {
        return new ModelMapper();
    }
}
