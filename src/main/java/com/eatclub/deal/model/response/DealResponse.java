package com.eatclub.deal.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DealResponse {
  private String restaurantObjectId;
  private String restaurantName;
  private String restaurantAddress1;
  private String restaurantSuburb;
  private String restaurantOpen;
  private String restaurantClose;
  private String dealObjectId;
  private String discount;
  private String dineIn;
  private String lightning;
  private String qtyLeft;

}
