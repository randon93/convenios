package com.grupo.xxiv.convenios.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@Configuration
@EnableSwagger2
@Profile({"dev"})
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.group.xiv.api.controller"))
                .build()
                .globalOperationParameters(headerParameters());
    }

    private List<Parameter> headerParameters() {
        return Lists.newArrayList(
                new ParameterBuilder()
                        .name("Accept-Language")
                        .description("Language")
                        .modelRef(new ModelRef("string"))
                        .parameterType("header")
                        .defaultValue("es")
                        .required(false)
                        .build(),

                new ParameterBuilder()
                        .name("Authorization")
                        .description("Access Token")
                        .modelRef(new ModelRef("string"))
                        .parameterType("header")
                        .defaultValue("Bearer ")
                        .required(false)
                        .build()
        );
    }

}
