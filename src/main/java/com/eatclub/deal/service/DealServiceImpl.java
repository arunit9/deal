package com.eatclub.deal.service;

import static com.eatclub.deal.util.TimeUtils.convertTo12HourClock;
import static com.eatclub.deal.util.TimeUtils.convertTo24HourClock;

import com.eatclub.deal.entity.Deal;
import com.eatclub.deal.entity.Restaurant;
import com.eatclub.deal.entity.Restaurants;
import com.eatclub.deal.exception.PeakNotFoundException;
import com.eatclub.deal.mapper.DealMapper;
import com.eatclub.deal.model.response.DealResponse;
import com.eatclub.deal.model.response.DealsResponse;
import com.eatclub.deal.model.response.PeakTimeResponse;
import com.eatclub.deal.restclient.RestaurantRestClient;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class DealServiceImpl implements DealService {
  private static final Logger logger = LoggerFactory.getLogger(DealServiceImpl.class);

  private final RestaurantRestClient restaurantRestClient;

  private final DealMapper dealMapper;

  @Value("${restaurants.api.url}")
  private String url;

  @Autowired
  public DealServiceImpl(RestaurantRestClient restaurantRestClient, DealMapper dealMapper) {
    this.restaurantRestClient = restaurantRestClient;
    this.dealMapper = dealMapper;
  }

  @Override
  public DealsResponse getDeals(Integer timeOfDay) {
    logger.debug("Executing get deals service method");
    Restaurants restaurants = restaurantRestClient.getData(url);
    List<DealResponse> deals = filterDeals(timeOfDay, restaurants);
    return DealsResponse.builder().deals(deals).build();
  }

  @Override
  public PeakTimeResponse getPeakTime() {
    logger.debug("Executing get peak time window service method");
    Restaurants restaurants = restaurantRestClient.getData(url);
    return findPeakTimeWindow(restaurants);
  }

  /**
   * Filters and transforms the input Restaurant data into Deals that are active at the specified timeOfDay
   * @param timeOfDay   the timeOfDay being queried
   * @param restaurants the restaurant data returned from the backend
   * @return            a list of DealResponse
   */
  private List<DealResponse> filterDeals(Integer timeOfDay, Restaurants restaurants) {
    logger.debug("Filtering deals by the timeOfDay {}", timeOfDay);
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
    int dealOpenTime = convertTo24HourClock(deal.getOpen() != null ? deal.getOpen() : restaurant.getOpen());
    int dealCloseTime = convertTo24HourClock(deal.getClose() != null ? deal.getClose() : restaurant.getClose());
    return time >= dealOpenTime && time < dealCloseTime;
  }

  /**
   * creates the DealResponse from the Deal and Restaurant data.
   *
   * @param deal        the deal object
   * @param restaurant  the restaurant object
   * @return            the DealResponse
   */
  private DealResponse map(Deal deal, Restaurant restaurant) {
    return dealMapper.mapDealResponse(deal, restaurant);
  }

  /**
   * Sets the restaurant's open and close times to the deal if the deal itself does not have open and close set.
   *
   * @param deal        the deal object
   * @param restaurant  the restaurant object
   * @return            the updated deal
   */
  private Deal updateOpenAndCloseTime(Deal deal, Restaurant restaurant) {
    if (deal.getOpen() == null) {
      deal.setOpen(restaurant.getOpen());
    }
    if (deal.getClose() == null) {
      deal.setClose(restaurant.getClose());
    }
    return deal;
  }

  public PeakTimeResponse findPeakTimeWindow(Restaurants restaurants) {
    // throw exception if no restaurants
    if (restaurants == null || CollectionUtils.isEmpty(restaurants.getRestaurants())) {
      throw new PeakNotFoundException("Peak time window cannot be found");
    }

    Map<Integer, Integer> availabilityByTimeslot = new TreeMap<>();

    // update the deal open, close times from the restaurant object if not set
    List<Deal> deals = restaurants.getRestaurants().stream()
        .flatMap(restaurant -> restaurant.getDeals().stream()
            .map(deal -> updateOpenAndCloseTime(deal, restaurant)))
        .toList();

    // create map to store the times at which the deals open and close and the counts of deals
    logger.debug("Creating a timeline of deal opening and closing for all deals");
    deals.forEach(deal -> createTimeEvents(availabilityByTimeslot, deal));

    // find the start and end times of the peak and if there are two peaks (same count), find the longest peak
    logger.debug("Executing the algorithm to find the peak time window");
    int maxDeals = 0;
    int maxStartTime = 0;
    int maxEndTime = 0;
    int dealCount = 0;
    boolean stop = false;
    int timeDiff = 0;
    TreeMap<Integer, PeakTimeResponse> peaks = new TreeMap<>();
    for (Entry<Integer, Integer> entry : availabilityByTimeslot.entrySet()) {
      dealCount = dealCount + entry.getValue();
      if (dealCount >= maxDeals) {
        maxStartTime = entry.getKey();
        maxDeals = dealCount;
        stop = false;
      }
      if (dealCount < maxDeals && !stop) {
        maxEndTime = entry.getKey();
        stop = true;
        timeDiff = maxEndTime - maxStartTime;
        peaks.put(timeDiff,
            PeakTimeResponse.builder()
            .peakTimeStart(convertTo12HourClock(maxStartTime))
            .peakTimeEnd(convertTo12HourClock(maxEndTime))
            .build());
      }
    }
    // return the peak with the largest time difference between its start and end
    return peaks.lastEntry().getValue();
  }

  private void createTimeEvents(Map<Integer, Integer> availabilityByTimeslot, Deal deal) {
    availabilityByTimeslot.compute(convertTo24HourClock(deal.getOpen()), (k,v) -> (v == null) ? 1 : v + 1);
    availabilityByTimeslot.compute(convertTo24HourClock(deal.getClose()), (k,v) -> (v == null) ? -1 : v - 1);
  }
}
