package com.example.demo.configuration;

import lombok.RequiredArgsConstructor;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties({BlockingRestTemplateProperties.class})
@RequiredArgsConstructor
public class BlockingRestTemplateCustomizer implements RestTemplateCustomizer {

  private final BlockingRestTemplateProperties properties;

  @Override
  public void customize(RestTemplate restTemplate) {
    restTemplate.setRequestFactory(clientHttpRequestFactory());
  }

  private ClientHttpRequestFactory clientHttpRequestFactory() {
    PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
    connectionManager.setMaxTotal(properties.maxTotal());
    connectionManager.setDefaultMaxPerRoute(properties.defaultMaxPerRoute());

    RequestConfig requestConfig =
        RequestConfig.custom()
            .setConnectionRequestTimeout(properties.connectionRequestTimeout())
            .setSocketTimeout(properties.socketTimeout())
            .build();

    CloseableHttpClient httpClient =
        HttpClients.custom()
            .setConnectionManager(connectionManager)
            .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
            .setDefaultRequestConfig(requestConfig)
            .build();

    return new HttpComponentsClientHttpRequestFactory(httpClient);
  }
}
