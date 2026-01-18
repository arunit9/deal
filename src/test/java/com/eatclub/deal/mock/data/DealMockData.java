package com.eatclub.deal.mock.data;

import com.eatclub.deal.model.response.DealResponse;
import com.eatclub.deal.model.response.DealsResponse;
import com.eatclub.deal.model.response.PeakTimeResponse;
import java.util.List;

public class DealMockData {

  public static final String RESTAURANT_OBJECT_ID = "DEA567C5-F64C-3C03-FF00-E3B24909BE00";
  public static final String RESTAURANT_NAME = "address1";
  public static final String RESTAURANT_ADDRESS_1 = "address1";
  public static final String RESTAURANT_SUBURB = "suburb1";
  public static final String RESTAURANT_OPEN = "3:00pm";
  public static final String RESTAURANT_CLOSE = "9:00pm";

  public static final String DEAL_1_OBJECT_ID = "DEA567C5-0000-3C03-FF00-E3B24909BE00";
  public static final String DEAL_1_DISCOUNT = "50";
  public static final String DEAL_1_DINE_IN = "true";
  public static final String DEAL_1_OPEN = "3:00pm";
  public static final String DEAL_1_CLOSE = "6:00pm";
  public static final String DEAL_1_LIGHTNING = "true";
  public static final String DEAL_1_QTY_LEFT = "5";

  public static final String DEAL_2_OBJECT_ID = "DEA567C5-0000-3C03-FF00-E3B24909BE00";
  public static final String DEAL_2_DISCOUNT = "50";
  public static final String DEAL_2_DINE_IN = "true";
  public static final String DEAL_2_OPEN = "3:00pm";
  public static final String DEAL_2_CLOSE = "6:00pm";
  public static final String DEAL_2_LIGHTNING = "true";
  public static final String DEAL_2_QTY_LEFT = "5";

  public static final String TIME_PARAM = "timeOfDay";
  public static final String PEAK_TIME_START = "3:00pm";
  public static final String PEAK_TIME_END = "9:00pm";

  public static DealResponse mockDealResponse(String dealObjectId, String discount, String dineIn,
      String lightning, String qtyLeft) {
    return DealResponse.builder()
        .restaurantObjectId(RESTAURANT_OBJECT_ID)
        .restaurantName(RESTAURANT_NAME)
        .restaurantAddress1(RESTAURANT_ADDRESS_1)
        .restaurantSuburb(RESTAURANT_SUBURB)
        .restaurantOpen(RESTAURANT_OPEN)
        .restaurantClose(RESTAURANT_CLOSE)
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
}
