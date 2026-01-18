package com.eatclub.deal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Deal {
  private String objectId;
  private String discount;
  private String dineIn;
  private String lightning;
  private String open;
  private String close;
  private String qtyLeft;
}
