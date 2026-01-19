package com.eatclub.deal.service;

import com.eatclub.deal.model.response.DealsResponse;
import com.eatclub.deal.model.response.PeakTimeResponse;

/**
 * This interface provides methods for working with deals.
 */
public interface DealService {

  /**
   * Returns the deals that are active at the specified time of day.
   *
   * @param timeOfDay the time for which active deals are queried
   * @return          DealsResponse containing information about deals
   */
  DealsResponse getDeals(Integer timeOfDay);

  /**
   * Returns the timeframe at which most deal number of are active within a day.
   *
   * @return  PeakTimeResponse containing the start and end of the peak timeframe
   */
  PeakTimeResponse getPeakTime();
}
