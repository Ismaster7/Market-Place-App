package com.marketplace.marketplace.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("Marketplace backend application")
                        .version("v1")
                        .description("Backend application")
                        .termsOfService("https://ismael.com.br")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://ismael.com.br")
                        )
                );
    }
}
