package com.example.demo.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties(RestTemplateConfigProps.class)
public class RestTemplateConfig {
  @Bean
  public RestTemplate restTemplate(RestTemplateConfigProps props) {
    return new RestTemplateBuilder().rootUri(props.host()).build();
  }
}
