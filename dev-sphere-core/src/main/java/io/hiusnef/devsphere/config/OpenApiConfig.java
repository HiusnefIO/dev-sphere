package io.hiusnef.devsphere.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "DevSphere Core Service API", 
        version = "v1.0", 
        description = "Core Service API for DevSphere Platform", 
        contact = @Contact(
            name = "DevSphere Development Team", 
            email = "contact@hiusnef.io.vn", 
            url = "https://hiusnef.io.vn")
        ), 
        servers = {
            @Server(
                url = "http://localhost:8080", 
                description = "Development Server")
            }, 
        security = {@SecurityRequirement(name = "bearer-jwt")})
@SecurityScheme(
    name = "bearer-jwt", 
    type = SecuritySchemeType.HTTP, 
    scheme = "bearer", 
    bearerFormat = "JWT")
public class OpenApiConfig {}