package com.eatclub.deal.service;

import static com.eatclub.deal.util.TimeUtils.convertClock;

import com.eatclub.deal.entity.Deal;
import com.eatclub.deal.entity.Restaurant;
import com.eatclub.deal.entity.Restaurants;
import com.eatclub.deal.model.response.DealResponse;
import com.eatclub.deal.model.response.DealsResponse;
import com.eatclub.deal.model.response.PeakTimeResponse;
import com.eatclub.deal.restclient.RestaurantRestClient;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DealServiceImpl implements DealService {

  private final RestaurantRestClient restaurantRestClient;

  @Value("${restaurants.api.url}")
  private String url;

  @Autowired
  public DealServiceImpl(RestaurantRestClient restaurantRestClient) {
    this.restaurantRestClient = restaurantRestClient;
  }

  @Override
  public DealsResponse getDeals(Integer timeOfDay) {
    Restaurants restaurants = restaurantRestClient.getData(url);
    List<DealResponse> deals = filterDeals(timeOfDay, restaurants);
    return DealsResponse.builder().deals(deals).build();
  }

  @Override
  public PeakTimeResponse getPeakTime() {
    Restaurants restaurants = restaurantRestClient.getData(url);
    // TODO find peak time
    return PeakTimeResponse.builder().build();
  }

  /**
   * Filters and transforms the input Restaurant data into Deals that are active at the specified timeOfDay
   * @param timeOfDay   the timeOfDay being queried
   * @param restaurants the restaurant data returned from the backend
   * @return            a list of DealResponse
   */
  private List<DealResponse> filterDeals(Integer timeOfDay, Restaurants restaurants) {
    if (timeOfDay == null) {
      return restaurants.getRestaurants().stream()
          .flatMap(restaurant -> restaurant.getDeals().stream()
              .map(deal -> map(deal, restaurant)) // convert Deals into DealResponse objects
          ).toList();
    }

    return restaurants.getRestaurants().stream()
        .flatMap(restaurant -> restaurant.getDeals().stream()
            .filter(deal -> filter(restaurant, deal, timeOfDay)) // filter deals matching the timeOfDay
            .map(deal -> map(deal, restaurant)) // convert filtered Deals into DealResponse objects
        ).toList();
  }

  /**
   * Method to filter deals that are active at the specified time
   * @param restaurant  the restaurant corresponding to the deal
   * @param deal        the deal
   * @param time        the time specified
   * @return            boolean
   */
  private boolean filter(Restaurant restaurant, Deal deal, int time) {
    int dealOpenTime = convertClock(deal.getOpen() != null ? deal.getOpen() : restaurant.getOpen());
    int dealCloseTime = convertClock(deal.getClose() != null ? deal.getClose() : restaurant.getClose());
    return time >= dealOpenTime && time <= dealCloseTime;
  }

  private DealResponse map(Deal deal, Restaurant restaurant) {
    return DealResponse.builder()
        .restaurantObjectId(restaurant.getObjectId())
        .restaurantName(restaurant.getName())
        .restaurantClose(restaurant.getClose())
        .restaurantOpen(restaurant.getOpen())
        .restaurantAddress1(restaurant.getAddress1())
        .restaurantSuburb(restaurant.getSuburb())
        .dealObjectId(deal.getObjectId())
        .discount(deal.getDiscount())
        .dineIn(deal.getDineIn())
        .lightning(deal.getLightning())
        .qtyLeft(deal.getQtyLeft()).build();
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
