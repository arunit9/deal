package com.eatclub.deal.restclient;

import com.eatclub.deal.entity.Restaurants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

/**
 * This class contains the logic to call the external backend apis.
 */
@Component
public class RestaurantRestClient {
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
    return restClient.get()
        .uri(url)
        .retrieve()
        .body(Restaurants.class);
  }
}
