package com.example.demo.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "mssc-beer-service.config.api")
public record RestTemplateConfigProps(
        String host,
        String getBeerByIdPath,
        String saveBeerPath,
        String updateBeerPath,
        String deleteBeerPath,
        String getCustomerByIdPath,
        String saveCustomerPath,
        String updateCustomerPath,
        String deleteCustomerPath
) {
}
