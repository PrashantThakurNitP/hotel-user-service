package com.hotelbooking.user_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {


    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("User Service - Hotel Booking Platform")
                        .version("1.0.0")
                        .description("API documentation for the User Service of the Hotel Booking platform. "
                                + "This service handles user registration, authentication, profile management, and logout functionality.")
                        .contact(new Contact()
                                .name("Prashant Thakur")
                                .email("prashant09.thakur@gmail.com")
                                .url("https://github.com/PrashantThakurNitP")));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public-apis")
                .pathsToMatch("/api/**")
                .build();
        /*
        Gives a name to the group; it becomes part of the OpenAPI URL: /v3/api-docs/public-apis
        Specifies that only endpoints starting with /api/ will be included in this group
         */
    }
}
