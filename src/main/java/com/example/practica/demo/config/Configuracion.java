package com.example.practica.demo.config;

import com.example.practica.demo.util.StringValidateService;
import com.example.practica.demo.util.StringValidateServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySources(value = {
    @PropertySource(value = {"classpath:messages.properties", "classpath:application.properties"})
})
public class Configuracion {

    @Bean
    public StringValidateService getStringValidateService() {
        return new StringValidateServiceImpl();
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
