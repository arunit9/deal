package com.eatclub.deal.service;

import com.eatclub.deal.model.response.DealsResponse;
import com.eatclub.deal.model.response.PeakTimeResponse;

public interface DealService {
  DealsResponse getDeals(String timeOfDay);

  PeakTimeResponse getPeakTime();
}
