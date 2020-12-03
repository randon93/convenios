package com.grupo.xxiv.convenios.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Converter {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
