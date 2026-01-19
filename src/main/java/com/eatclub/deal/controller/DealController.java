package com.eatclub.deal.controller;

import static com.eatclub.deal.util.TimeUtils.convertClock;

import com.eatclub.deal.model.response.DealsResponse;
import com.eatclub.deal.model.response.PeakTimeResponse;
import com.eatclub.deal.service.DealService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Manages the API endpoints for deal related operations, such as
 * retrieving and finding the peak time for deals. This class
 * acts as a web controller within the Spring framework, handling
 * HTTP requests and returning appropriate responses.
 */
@RestController
@RequestMapping("/api/deals")
public class DealController {
  private static final Logger logger = LoggerFactory.getLogger(DealController.class);

  private final DealService dealService;

  public DealController(DealService dealService) {
    this.dealService = dealService;
  }

  /**
   * The method handles the HTTP GET request for restaurant deals
   * with an optional parameter to filter deals active at a specified time of day.
   *
   * @param timeOfDay the time for which active deals are queried
   * @return          The DealsResponse object containing information about deals
   */
  @GetMapping
  public DealsResponse getDeals(@RequestParam(value = "timeOfDay", required = false) String timeOfDay) {
    logger.debug("Executing of deals api");
    Integer time = null;
    // validate and convert the timeOfDay
    if (timeOfDay != null) {
      time = convertClock(timeOfDay);
    }
    return dealService.getDeals(time);
  }

  /**
   *The method handles the HTTP GET request for peak time window for deals.
   *
   * @return  PeakTimeResponse object containing the start and end of the peak time window
   */
  @GetMapping("/peak")
  public PeakTimeResponse getPeakTime() {
    logger.debug("Executing deals/peak api");
    return dealService.getPeakTime();
  }
}
