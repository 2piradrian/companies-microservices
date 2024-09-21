package com.twopiardrian.companiescrud.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Companies CRUD API",
                version = "1.0",
                description = "Companies CRUD API"
        )
)
public class OpenApiConfig {

}
