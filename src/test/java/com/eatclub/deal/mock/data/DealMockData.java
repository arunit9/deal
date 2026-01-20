package com.eatclub.deal.mock.data;

import com.eatclub.deal.entity.Deal;
import com.eatclub.deal.entity.Restaurant;
import com.eatclub.deal.entity.Restaurants;
import com.eatclub.deal.model.response.DealResponse;
import com.eatclub.deal.model.response.DealsResponse;
import com.eatclub.deal.model.response.PeakTimeResponse;
import java.util.List;

public class DealMockData {

  public static final String RESTAURANT_1_OBJECT_ID = "AEA567C5-F64C-3C03-FF00-E3B24909BE00";
  public static final String RESTAURANT_1_NAME = "name1";
  public static final String RESTAURANT_1_ADDRESS_1 = "address1";
  public static final String RESTAURANT_1_SUBURB = "suburb1";
  public static final String RESTAURANT_1_OPEN = "3:00pm";
  public static final String RESTAURANT_1_CLOSE = "9:00pm";

  public static final String RESTAURANT_2_OBJECT_ID = "AEA567C5-F64C-3C03-FF00-E3B24909BE01";
  public static final String RESTAURANT_2_NAME = "name2";
  public static final String RESTAURANT_2_ADDRESS_1 = "address2";
  public static final String RESTAURANT_2_SUBURB = "suburb2";
  public static final String RESTAURANT_2_OPEN = "12:00pm";
  public static final String RESTAURANT_2_CLOSE = "4:00pm";

  public static final String RESTAURANT_3_OBJECT_ID = "AEA567C5-F64C-3C03-FF00-E3B24909BE02";
  public static final String RESTAURANT_3_NAME = "name3";
  public static final String RESTAURANT_3_ADDRESS_1 = "address3";
  public static final String RESTAURANT_3_SUBURB = "suburb3";
  public static final String RESTAURANT_3_OPEN = "5:00pm";
  public static final String RESTAURANT_3_CLOSE = "11:00pm";

  public static final String RESTAURANT_4_OBJECT_ID = "AEA567C5-F64C-3C03-FF00-E3B24909BE03";
  public static final String RESTAURANT_4_NAME = "name4";
  public static final String RESTAURANT_4_ADDRESS_1 = "address4";
  public static final String RESTAURANT_4_SUBURB = "suburb4";
  public static final String RESTAURANT_4_OPEN = "4:00pm";
  public static final String RESTAURANT_4_CLOSE = "6:00pm";

  public static final String DEAL_1_OBJECT_ID = "DEA567C5-0000-3C03-FF00-E3B24909BE00";
  public static final String DEAL_1_DISCOUNT = "50";
  public static final String DEAL_1_DINE_IN = "true";
  public static final String DEAL_1_OPEN = "3:00pm";
  public static final String DEAL_1_CLOSE = "8:00pm";
  public static final String DEAL_1_LIGHTNING = "true";
  public static final String DEAL_1_QTY_LEFT = "5";

  public static final String DEAL_2_OBJECT_ID = "DEA567C5-0000-3C03-FF00-E3B24909BE01";
  public static final String DEAL_2_DISCOUNT = "40";
  public static final String DEAL_2_DINE_IN = "false";
  public static final String DEAL_2_OPEN = "8:00pm";
  public static final String DEAL_2_CLOSE = "9:00pm";
  public static final String DEAL_2_LIGHTNING = "true";
  public static final String DEAL_2_QTY_LEFT = "4";

  public static final String DEAL_3_OBJECT_ID = "DEA567C5-0000-3C03-FF00-E3B24909BE02";
  public static final String DEAL_3_DISCOUNT = "30";
  public static final String DEAL_3_DINE_IN = "true";
  public static final String DEAL_3_OPEN = null;
  public static final String DEAL_3_CLOSE = null;
  public static final String DEAL_3_LIGHTNING = "true";
  public static final String DEAL_3_QTY_LEFT = "3";

  public static final String DEAL_4_OBJECT_ID = "DEA567C5-0000-3C03-FF00-E3B24909BE03";
  public static final String DEAL_4_DISCOUNT = "30";
  public static final String DEAL_4_DINE_IN = "true";
  public static final String DEAL_4_OPEN = "2:00pm";
  public static final String DEAL_4_CLOSE = "4:00pm";
  public static final String DEAL_4_LIGHTNING = "true";
  public static final String DEAL_4_QTY_LEFT = "3";

  public static final String DEAL_5_OBJECT_ID = "DEA567C5-0000-3C03-FF00-E3B24909BE04";
  public static final String DEAL_5_DISCOUNT = "30";
  public static final String DEAL_5_DINE_IN = "true";
  public static final String DEAL_5_OPEN = "6:00pm";
  public static final String DEAL_5_CLOSE = "8:00pm";
  public static final String DEAL_5_LIGHTNING = "true";
  public static final String DEAL_5_QTY_LEFT = "3";

  public static final String DEAL_6_OBJECT_ID = "DEA567C5-0000-3C03-FF00-E3B24909BE05";
  public static final String DEAL_6_DISCOUNT = "10";
  public static final String DEAL_6_DINE_IN = "false";
  public static final String DEAL_6_OPEN = "6:00pm";
  public static final String DEAL_6_CLOSE = "9:00pm";
  public static final String DEAL_6_LIGHTNING = "true";
  public static final String DEAL_6_QTY_LEFT = "3";

  public static final String DEAL_7_OBJECT_ID = "DEA567C5-0000-3C03-FF00-E3B24909BE06";
  public static final String DEAL_7_DISCOUNT = "10";
  public static final String DEAL_7_DINE_IN = "false";
  public static final String DEAL_7_OPEN = "4:30pm";
  public static final String DEAL_7_CLOSE = "6:00pm";
  public static final String DEAL_7_LIGHTNING = "true";
  public static final String DEAL_7_QTY_LEFT = "3";

  public static final String DEAL_8_OBJECT_ID = "DEA567C5-0000-3C03-FF00-E3B24909BE07";
  public static final String DEAL_8_DISCOUNT = "10";
  public static final String DEAL_8_DINE_IN = "true";
  public static final String DEAL_8_OPEN = null;
  public static final String DEAL_8_CLOSE = null;
  public static final String DEAL_8_LIGHTNING = "true";
  public static final String DEAL_8_QTY_LEFT = "5";

  public static final String DEAL_9_OBJECT_ID = "DEA567C5-0000-3C03-FF00-E3B24909BE08";
  public static final String DEAL_9_DISCOUNT = "10";
  public static final String DEAL_9_DINE_IN = "false";
  public static final String DEAL_9_OPEN = "4:00pm";
  public static final String DEAL_9_CLOSE = "5:00pm";
  public static final String DEAL_9_LIGHTNING = "true";
  public static final String DEAL_9_QTY_LEFT = "3";

  public static final String TIME_PARAM = "timeOfDay";
  public static final String PEAK_TIME_START = "3:00pm";
  public static final String PEAK_TIME_END = "9:00pm";

  public static DealResponse mockDealResponse(String dealObjectId, String discount, String dineIn,
      String lightning, String qtyLeft) {
    return DealResponse.builder()
        .restaurantObjectId(RESTAURANT_1_OBJECT_ID)
        .restaurantName(RESTAURANT_1_NAME)
        .restaurantAddress1(RESTAURANT_1_ADDRESS_1)
        .restaurantSuburb(RESTAURANT_1_SUBURB)
        .restaurantOpen(RESTAURANT_1_OPEN)
        .restaurantClose(RESTAURANT_1_CLOSE)
        .dealObjectId(dealObjectId)
        .discount(discount)
        .dineIn(dineIn)
        .lightning(lightning)
        .qtyLeft(qtyLeft)
        .build();
  }

  public static DealsResponse mockDealsResponse(List<DealResponse> dealResponses) {
    return DealsResponse.builder()
        .deals(dealResponses)
        .build();
  }

  public static PeakTimeResponse mockPeakTimeResponse() {
    return PeakTimeResponse.builder()
        .peakTimeStart(PEAK_TIME_START)
        .peakTimeEnd(PEAK_TIME_END)
        .build();
  }

  public static Restaurants mockRestaurants(List<Restaurant> restaurants) {
    return Restaurants.builder().restaurants(restaurants).build();
  }

  public static Restaurant mockRestaurant(String restaurantObjectId, String name, String address1,
      String suburb, String open, String close, List<Deal> deals) {
    return Restaurant.builder()
        .objectId(restaurantObjectId)
        .name(name)
        .address1(address1)
        .suburb(suburb)
        .open(open)
        .close(close)
        .cuisines(List.of("Contemporary", "Soup", "Salads"))
        .imageLink("IMG001")
        .deals(deals)
        .build();
  }

  public static Deal mockDeal(String dealObjectId, String discount, String dineIn, String open, String close,
      String lightning, String qtyLeft) {
    return Deal.builder()
        .objectId(dealObjectId)
        .discount(discount)
        .dineIn(dineIn)
        .open(open)
        .close(close)
        .lightning(lightning)
        .qtyLeft(qtyLeft)
        .build();
  }
}
