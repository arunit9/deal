package com.eatclub.deal.mapper;

import com.eatclub.deal.entity.Deal;
import com.eatclub.deal.entity.Restaurant;
import com.eatclub.deal.model.response.DealResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DealMapper {

  @Mapping(source = "deal.objectId", target = "dealObjectId")
  @Mapping(source = "deal.discount", target = "discount")
  @Mapping(source = "deal.dineIn", target = "dineIn")
  @Mapping(source = "deal.lightning", target = "lightning")
  @Mapping(source = "deal.qtyLeft", target = "qtyLeft")
  @Mapping(source = "restaurant.objectId", target = "restaurantObjectId")
  @Mapping(source = "restaurant.name", target = "restaurantName")
  @Mapping(source = "restaurant.close", target = "restaurantClose")
  @Mapping(source = "restaurant.open", target = "restaurantOpen")
  @Mapping(source = "restaurant.address1", target = "restaurantAddress1")
  @Mapping(source = "restaurant.suburb", target = "restaurantSuburb")
  DealResponse mapDealResponse(Deal deal, Restaurant restaurant);
}
