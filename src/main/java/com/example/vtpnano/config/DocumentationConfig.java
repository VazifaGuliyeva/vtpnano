package com.example.vtpnano.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class DocumentationConfig {
  //     http://localhost:8080/swagger-ui/index.html#/
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(
                new Info().title("Documentation by Vazifa Guliyeva")
                        .version("0.0.1")
                        .description("This service is written for VtpNano")
                        .contact(
                                new Contact()
                                        .url("www.vtpnano.com")
                                        .email("vazifa@gmail.com")
                                        .name("Vazifa Guliyeva")
                        )
        );
    }
}
