package com.prestamofacilweb.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrestamoFacilConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
