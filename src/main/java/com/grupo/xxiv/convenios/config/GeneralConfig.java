package com.grupo.xxiv.convenios.config;

import common.service.ConverterService;
import common.service.ValidationService;
import common.service.impl.ConverterServiceImpl;
import common.service.impl.ValidationServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;
import java.util.TimeZone;

@Configuration
@Slf4j
public class GeneralConfig {

    @Autowired
    private TimeZoneProperties timeZoneProperties;

    @Bean
    public ConverterService converterService() {
        return new ConverterServiceImpl();
    }

    @Bean
    public ValidationService validationService() {
        return new ValidationServiceImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedHeaders("*")
                        .allowedMethods("POST", "GET", "PUT", "OPTIONS", "POST", "DELETE");
            }

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addRedirectViewController("/api-controllers", "/swagger-ui.html");
            }

            @Override
            public Validator getValidator() {
                LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
                bean.setValidationMessageSource(messageSource());
                return bean;
            }
        };
    }

    @Bean
    public LocaleResolver localeResolver() {
        Locale defaultLocale = new Locale("es", "CO");
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setDefaultLocale(defaultLocale);
        Locale.setDefault(defaultLocale);
        return localeResolver;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public TimeZone timeZone() {
        System.out.println("TimeZone del sistema: " + TimeZone.getDefault().toZoneId());
        TimeZone timeZone = TimeZone.getTimeZone(timeZoneProperties.getZoneId());
        TimeZone.setDefault(timeZone);
        log.info(" :: TIMEZONE :: NUEVA TIMEZONE :: " + timeZone.toZoneId());
        System.out.println("Nueva TimeZone: " + timeZone.toZoneId());
        return timeZone;
    }
}

