package com.marketplace.marketplace.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {


        configurer.favorParameter(false) // Se for parametros via query params, devo tornar esta linha true
                //.parameterName("mediaType")// Se for parametros via query params, devo descomentar esta linha
                .ignoreAcceptHeader(false)// Se for parametros via query params, devo tornar esta linha true
                .useRegisteredExtensionsOnly(true)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML);

    }
}
