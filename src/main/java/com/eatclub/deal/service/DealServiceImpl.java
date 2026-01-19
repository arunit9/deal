package com.eatclub.deal.service;

import static com.eatclub.deal.util.TimeUtils.convertTo12HourClock;
import static com.eatclub.deal.util.TimeUtils.convertTo24HourClock;

import com.eatclub.deal.entity.Deal;
import com.eatclub.deal.entity.Restaurant;
import com.eatclub.deal.entity.Restaurants;
import com.eatclub.deal.exception.PeakNotFoundException;
import com.eatclub.deal.model.response.DealResponse;
import com.eatclub.deal.model.response.DealsResponse;
import com.eatclub.deal.model.response.PeakTimeResponse;
import com.eatclub.deal.restclient.RestaurantRestClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
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
    return findPeakTimeWindow(restaurants);
  }

  /**
   * This method finds the peak time window in which the highest number of deals are active within a day.
   *
   * @param restaurants the restaurants data
   * @return            PeakTimeResponse object
   */
  private PeakTimeResponse findPeakTimeWindow(Restaurants restaurants) {
    // create map for 24 hour slots of the day and for each deal increment a counter for the timeslots for which it is active
    Map<Integer, Integer> availabilityByTimeslot = new TreeMap<>();
    List<Deal> deals = restaurants.getRestaurants().stream()
        .flatMap(restaurant -> restaurant.getDeals().stream()
            .map(deal -> updateOpenAndCloseTime(deal, restaurant)))
        .toList();
    deals.forEach(deal -> {
      List<Integer> timeRange = findActiveTimeRange(deal);
      timeRange.forEach(t -> availabilityByTimeslot.compute(t, (k,v) -> (v == null) ? 1 : v + 1));
    });

    // Find the timeslots with the maximum count value
    int maxValue = availabilityByTimeslot.entrySet().stream()
        .max(Map.Entry.comparingByValue())
        .map(Map.Entry::getValue)
        .orElse(0);

    // Filter entries with the maximum value and collect their keys
    List<Integer> keys = availabilityByTimeslot.entrySet().stream()
        .filter(entry -> entry.getValue() == maxValue)
        .map(Map.Entry::getKey).toList();

    // throw exception if a peak time window cannot be found
    if (keys.isEmpty()) {
      throw new PeakNotFoundException("Peak time window cannot be found");
    }
    // if only one timeslot has the max count value, then that hour is the peak
    if (keys.size() == 1) {
      return PeakTimeResponse.builder()
          .peakTimeStart(convertTo12HourClock(keys.getFirst()))
          .peakTimeEnd(convertTo12HourClock(keys.getFirst() + 100))
          .build();
    }

    // if there are multiple timeslots with the max value, then find the longest consecutive hours to calculate the peak
    // for example if peak hourly slots are [11am, 12pm, 3pm, 4pm, 5pm, 6pm] - the peak is from 3pm-6pm
    Map<Integer, Integer> longestPeak = findLongestPeak(keys);
    int maxConsecutiveHoursAtPeak = longestPeak.entrySet().stream()
        .max(Map.Entry.comparingByValue())
        .map(Map.Entry::getValue)
        .orElse(0);

    // Filter entries with the maximum value and collect their keys
    List<Integer> endingHourOfLongestPeak = longestPeak.entrySet().stream()
        .filter(entry -> entry.getValue() == maxConsecutiveHoursAtPeak)
        .map(Map.Entry::getKey).toList();

    return PeakTimeResponse.builder()
        .peakTimeEnd(convertTo12HourClock(endingHourOfLongestPeak.getFirst() + 100))
        .peakTimeStart(convertTo12HourClock(endingHourOfLongestPeak.getFirst() - maxConsecutiveHoursAtPeak * 100))
        .build();
  }

  /**
   * This method finds the longest consecutive hours that could contain the peak
   * @param timeslots the list of 1 hour timeslots that have the highest count of deals
   * @return          a map with consecutive timeslots grouped as the key
   *                  and the number of consecutive hourly slots within the group as the value
   */
  private static Map<Integer, Integer> findLongestPeak(List<Integer> timeslots) {
    Map<Integer, Integer> longestPeak = new TreeMap<>();
    for (int i = 0; i < timeslots.size(); i++) {
      // check if the next key is one hour ahead
      int count = 0;
      for (int j = i + 1; j < timeslots.size(); j++) {
        if (timeslots.get(i) + 100 == timeslots.get(j)) {
          count++;
          i++;
        } else {
          break;
        }
      }
      longestPeak.put(timeslots.get(i), count);
    }
    return longestPeak;
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
    int dealOpenTime = convertTo24HourClock(deal.getOpen() != null ? deal.getOpen() : restaurant.getOpen());
    int dealCloseTime = convertTo24HourClock(deal.getClose() != null ? deal.getClose() : restaurant.getClose());
    return time >= dealOpenTime && time <= dealCloseTime;
  }

  /**
   * creates the DealResponse from the Deal and Restaurant data.
   *
   * @param deal        the deal object
   * @param restaurant  the restaurant object
   * @return            the DealResponse
   */
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

  /**
   * returns a lit of hourly time ranges within the open and close times of a deal.
   *
   * @param deal  the deal object
   * @return      List<Integer> of hourly time ranges (Integer value will be the start time of the range)
   */
  private List<Integer> findActiveTimeRange(Deal deal) {
    int dealOpenTime = convertTo24HourClock(deal.getOpen());
    int dealCloseTime = convertTo24HourClock(deal.getClose());
    // Assuming that the times are in hourly increments
    List<Integer> timeRange = new ArrayList<>();
    for (int i = dealOpenTime; i < dealCloseTime; i = i + 100) {
      timeRange.add(i);
    }
    return timeRange;
  }
}
