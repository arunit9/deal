package com.eatclub.deal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class DealConfiguration {
  @Bean
  public RestClient restClient() {
    // You can add base URLs, default headers, etc. here if needed
    return RestClient.builder().build();
  }
}
