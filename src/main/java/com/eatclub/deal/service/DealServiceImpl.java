package com.eatclub.deal.service;

import com.eatclub.deal.entity.Restaurants;
import com.eatclub.deal.model.response.DealsResponse;
import com.eatclub.deal.model.response.PeakTimeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class DealServiceImpl implements DealService {

  private final RestClient restClient;

  @Value("${restaurants.api.url}")
  private String url;

  @Autowired
  public DealServiceImpl(RestClient restClient) {
    this.restClient = restClient;
  }

  @Override
  public DealsResponse getDeals(String timeOfDay) {
    Restaurants restaurants = getData();
    // TODO write the filtering and transformation logic
    return DealsResponse.builder().build();
  }

  @Override
  public PeakTimeResponse getPeakTime() {
    Restaurants restaurants = getData();
    // TODO find peak time
    return PeakTimeResponse.builder().build();
  }

  private Restaurants getData() {
    return restClient.get()
        .uri(url)
        .retrieve()
        .body(Restaurants.class);
  }
}
