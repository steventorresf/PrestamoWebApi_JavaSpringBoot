package com.prestamofacilweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Prestamo Fácil Web API")
                        .description("Aplicación para gestionar los prestamos en la web")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Steven Torres Fernández")
                                .email("steventorresf@gmail.com")));
    }
}
