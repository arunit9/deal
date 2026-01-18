package com.eatclub.deal.controller;

import com.eatclub.deal.model.response.DealsResponse;
import com.eatclub.deal.model.response.PeakTimeResponse;
import com.eatclub.deal.service.DealService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deals")
public class DealController {
  private static final Logger logger = LoggerFactory.getLogger(DealController.class);

  private final DealService dealService;

  public DealController(DealService dealService) {
    this.dealService = dealService;
  }

  @GetMapping
  public DealsResponse getDeals(@RequestParam(value = "timeOfDay", required = false) String timeOfDay) {
    logger.debug("Executing of deals api");
    return dealService.getDeals(timeOfDay);
  }

  @GetMapping("/peak")
  public PeakTimeResponse getPeakTime() {
    logger.debug("Executing deals/peak api");
    return dealService.getPeakTime();
  }
}
