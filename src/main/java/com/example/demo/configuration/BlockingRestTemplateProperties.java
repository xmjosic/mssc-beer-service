package com.example.demo.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
@ConfigurationProperties(prefix = "mssc-beer-service.config.blocking-rest-template")
@ConstructorBinding
public record BlockingRestTemplateProperties(
        @NotNull(message = "Max total is required.") Integer maxTotal,
        @NotNull(message = "Default max per route is required.") Integer defaultMaxPerRoute,
        @NotNull(message = "connection request timeout is required.") Integer connectionRequestTimeout,
        @NotNull(message = "Socket timeout is required.") Integer socketTimeout
) {
}
