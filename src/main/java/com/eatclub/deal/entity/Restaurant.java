package com.eatclub.deal.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
  private String objectId;
  private String name;
  private String address1;
  private String suburb;
  private List<String> cuisines;
  private String imageLink;
  private String open;
  private String close;
  private List<Deal> deals;
}
