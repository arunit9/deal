package com.eatclub.deal.service;

import com.eatclub.deal.entity.Restaurants;
import com.eatclub.deal.model.response.DealsResponse;
import com.eatclub.deal.model.response.PeakTimeResponse;
import org.springframework.stereotype.Service;

@Service
public class DealServiceImpl implements DealService {

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
    return Restaurants.builder().build();
  }
}
