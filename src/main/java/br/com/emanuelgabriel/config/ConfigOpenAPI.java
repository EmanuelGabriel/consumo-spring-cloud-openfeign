package br.com.emanuelgabriel.config;

import org.springdoc.webmvc.ui.SwaggerConfig;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;


@OpenAPIDefinition(
info = @Info(description = "Documentação da API REST",
termsOfService = "Termos de uso",
title = "Consumo de API REST Externa com Spring Cloud OpenFeign",
version = "1.0.0",
contact = @Contact(name = "Emanuel Gabriel Sousa", 
email = "emanuel.gabriel.sousa@protonmail.com")))
public class ConfigOpenAPI extends SwaggerConfig {

}
