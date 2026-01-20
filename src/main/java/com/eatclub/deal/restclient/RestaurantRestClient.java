package com.eatclub.deal.restclient;

import com.eatclub.deal.entity.Restaurants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

/**
 * This class contains the logic to call the external backend apis.
 */
@Component
public class RestaurantRestClient {
  private static final Logger logger = LoggerFactory.getLogger(RestaurantRestClient.class);
  private final RestClient restClient;

  @Autowired
  public RestaurantRestClient(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * This method invokes an external api call to the specified url.
   *
   * @param url the url of the external api
   * @return    the response converted to a java object
   */
  public Restaurants getData(String url) {
    logger.debug("Getting data from external restaurants api");
    return restClient.get()
        .uri(url)
        .retrieve()
        .body(Restaurants.class);
  }
}
