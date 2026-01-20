package com.eatclub.deal.service;

import static com.eatclub.deal.mock.data.DealMockData.DEAL_1_CLOSE;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_1_DINE_IN;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_1_DISCOUNT;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_1_LIGHTNING;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_1_OBJECT_ID;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_1_OPEN;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_1_QTY_LEFT;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_2_CLOSE;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_2_DINE_IN;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_2_DISCOUNT;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_2_LIGHTNING;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_2_OBJECT_ID;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_2_OPEN;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_2_QTY_LEFT;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_3_CLOSE;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_3_DINE_IN;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_3_DISCOUNT;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_3_LIGHTNING;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_3_OBJECT_ID;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_3_OPEN;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_3_QTY_LEFT;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_4_CLOSE;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_4_DINE_IN;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_4_DISCOUNT;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_4_LIGHTNING;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_4_OBJECT_ID;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_4_OPEN;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_4_QTY_LEFT;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_5_CLOSE;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_5_DINE_IN;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_5_DISCOUNT;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_5_LIGHTNING;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_5_OBJECT_ID;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_5_OPEN;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_5_QTY_LEFT;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_6_CLOSE;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_6_DINE_IN;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_6_DISCOUNT;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_6_LIGHTNING;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_6_OBJECT_ID;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_6_OPEN;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_6_QTY_LEFT;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_7_CLOSE;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_7_DINE_IN;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_7_DISCOUNT;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_7_LIGHTNING;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_7_OBJECT_ID;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_7_OPEN;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_7_QTY_LEFT;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_8_CLOSE;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_8_DINE_IN;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_8_DISCOUNT;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_8_LIGHTNING;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_8_OBJECT_ID;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_8_OPEN;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_8_QTY_LEFT;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_9_CLOSE;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_9_DINE_IN;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_9_DISCOUNT;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_9_LIGHTNING;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_9_OBJECT_ID;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_9_OPEN;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_9_QTY_LEFT;
import static com.eatclub.deal.mock.data.DealMockData.RESTAURANT_1_ADDRESS_1;
import static com.eatclub.deal.mock.data.DealMockData.RESTAURANT_1_CLOSE;
import static com.eatclub.deal.mock.data.DealMockData.RESTAURANT_1_NAME;
import static com.eatclub.deal.mock.data.DealMockData.RESTAURANT_1_OBJECT_ID;
import static com.eatclub.deal.mock.data.DealMockData.RESTAURANT_1_OPEN;
import static com.eatclub.deal.mock.data.DealMockData.RESTAURANT_1_SUBURB;
import static com.eatclub.deal.mock.data.DealMockData.RESTAURANT_2_ADDRESS_1;
import static com.eatclub.deal.mock.data.DealMockData.RESTAURANT_2_CLOSE;
import static com.eatclub.deal.mock.data.DealMockData.RESTAURANT_2_NAME;
import static com.eatclub.deal.mock.data.DealMockData.RESTAURANT_2_OBJECT_ID;
import static com.eatclub.deal.mock.data.DealMockData.RESTAURANT_2_OPEN;
import static com.eatclub.deal.mock.data.DealMockData.RESTAURANT_2_SUBURB;
import static com.eatclub.deal.mock.data.DealMockData.RESTAURANT_3_ADDRESS_1;
import static com.eatclub.deal.mock.data.DealMockData.RESTAURANT_3_CLOSE;
import static com.eatclub.deal.mock.data.DealMockData.RESTAURANT_3_NAME;
import static com.eatclub.deal.mock.data.DealMockData.RESTAURANT_3_OBJECT_ID;
import static com.eatclub.deal.mock.data.DealMockData.RESTAURANT_3_OPEN;
import static com.eatclub.deal.mock.data.DealMockData.RESTAURANT_3_SUBURB;
import static com.eatclub.deal.mock.data.DealMockData.RESTAURANT_4_ADDRESS_1;
import static com.eatclub.deal.mock.data.DealMockData.RESTAURANT_4_CLOSE;
import static com.eatclub.deal.mock.data.DealMockData.RESTAURANT_4_NAME;
import static com.eatclub.deal.mock.data.DealMockData.RESTAURANT_4_OBJECT_ID;
import static com.eatclub.deal.mock.data.DealMockData.RESTAURANT_4_OPEN;
import static com.eatclub.deal.mock.data.DealMockData.RESTAURANT_4_SUBURB;
import static com.eatclub.deal.mock.data.DealMockData.mockDeal;
import static com.eatclub.deal.mock.data.DealMockData.mockRestaurant;
import static com.eatclub.deal.mock.data.DealMockData.mockRestaurants;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.eatclub.deal.entity.Deal;
import com.eatclub.deal.entity.Restaurant;
import com.eatclub.deal.entity.Restaurants;
import com.eatclub.deal.exception.PeakNotFoundException;
import com.eatclub.deal.mapper.DealMapper;
import com.eatclub.deal.model.response.DealsResponse;
import com.eatclub.deal.model.response.PeakTimeResponse;
import com.eatclub.deal.restclient.RestaurantRestClient;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@TestPropertySource(locations = "classpath:application.properties")
@SpringBootTest
class DealServiceTest {
  private DealService dealService;

  @MockitoBean
  private RestaurantRestClient restaurantRestClient;

  @Autowired
  private DealMapper dealMapper;

  @BeforeEach
  void setUp() {
    dealService = new DealServiceImpl(restaurantRestClient, dealMapper);
  }

  @Test
  void whenGetDealsWithoutTimeOfDay_thenThreeDealsReturned() {
    Deal deal1 = mockDeal(DEAL_1_OBJECT_ID, DEAL_1_DISCOUNT, DEAL_1_DINE_IN, DEAL_1_OPEN, DEAL_1_CLOSE,
        DEAL_1_LIGHTNING, DEAL_1_QTY_LEFT);
    Deal deal2 = mockDeal(DEAL_2_OBJECT_ID, DEAL_2_DISCOUNT, DEAL_2_DINE_IN, DEAL_2_OPEN, DEAL_2_CLOSE,
        DEAL_2_LIGHTNING, DEAL_2_QTY_LEFT);
    Deal deal3 = mockDeal(DEAL_3_OBJECT_ID, DEAL_3_DISCOUNT, DEAL_3_DINE_IN, DEAL_3_OPEN, DEAL_3_CLOSE,
        DEAL_3_LIGHTNING, DEAL_3_QTY_LEFT);

    Restaurant restaurant1 = mockRestaurant(RESTAURANT_1_OBJECT_ID, RESTAURANT_1_NAME, RESTAURANT_1_ADDRESS_1,
        RESTAURANT_1_SUBURB, RESTAURANT_1_OPEN, RESTAURANT_1_CLOSE, List.of(deal1, deal2));
    Restaurant restaurant2 = mockRestaurant(RESTAURANT_2_OBJECT_ID, RESTAURANT_2_NAME, RESTAURANT_2_ADDRESS_1,
        RESTAURANT_2_SUBURB, RESTAURANT_2_OPEN, RESTAURANT_2_CLOSE, List.of(deal3));

    Restaurants restaurants = mockRestaurants(List.of(restaurant1, restaurant2));

    when(restaurantRestClient.getData(any())).thenReturn(restaurants);

    DealsResponse result = dealService.getDeals(null);

    // assert deal 1 data
    assertEquals(restaurant1.getObjectId(), result.getDeals().getFirst().getRestaurantObjectId());
    assertEquals(restaurant1.getName(), result.getDeals().getFirst().getRestaurantName());
    assertEquals(restaurant1.getAddress1(), result.getDeals().getFirst().getRestaurantAddress1());
    assertEquals(restaurant1.getSuburb(), result.getDeals().getFirst().getRestaurantSuburb());
    assertEquals(restaurant1.getOpen(), result.getDeals().getFirst().getRestaurantOpen());
    assertEquals(restaurant1.getClose(), result.getDeals().getFirst().getRestaurantClose());
    assertEquals(deal1.getObjectId(), result.getDeals().getFirst().getDealObjectId());
    assertEquals(deal1.getDiscount(), result.getDeals().getFirst().getDiscount());
    assertEquals(deal1.getDineIn(), result.getDeals().getFirst().getDineIn());
    assertEquals(deal1.getLightning(), result.getDeals().getFirst().getLightning());
    assertEquals(deal1.getQtyLeft(), result.getDeals().getFirst().getQtyLeft());

    // assert deal 2 data
    assertEquals(restaurant1.getObjectId(), result.getDeals().get(1).getRestaurantObjectId());
    assertEquals(restaurant1.getName(), result.getDeals().get(1).getRestaurantName());
    assertEquals(restaurant1.getAddress1(), result.getDeals().get(1).getRestaurantAddress1());
    assertEquals(restaurant1.getSuburb(), result.getDeals().get(1).getRestaurantSuburb());
    assertEquals(restaurant1.getOpen(), result.getDeals().get(1).getRestaurantOpen());
    assertEquals(restaurant1.getClose(), result.getDeals().get(1).getRestaurantClose());
    assertEquals(deal2.getObjectId(), result.getDeals().get(1).getDealObjectId());
    assertEquals(deal2.getDiscount(), result.getDeals().get(1).getDiscount());
    assertEquals(deal2.getDineIn(), result.getDeals().get(1).getDineIn());
    assertEquals(deal2.getLightning(), result.getDeals().get(1).getLightning());
    assertEquals(deal2.getQtyLeft(), result.getDeals().get(1).getQtyLeft());

    // assert deal 3 data
    assertEquals(restaurant2.getObjectId(), result.getDeals().get(2).getRestaurantObjectId());
    assertEquals(restaurant2.getName(), result.getDeals().get(2).getRestaurantName());
    assertEquals(restaurant2.getAddress1(), result.getDeals().get(2).getRestaurantAddress1());
    assertEquals(restaurant2.getSuburb(), result.getDeals().get(2).getRestaurantSuburb());
    assertEquals(restaurant2.getOpen(), result.getDeals().get(2).getRestaurantOpen());
    assertEquals(restaurant2.getClose(), result.getDeals().get(2).getRestaurantClose());
    assertEquals(deal3.getObjectId(), result.getDeals().get(2).getDealObjectId());
    assertEquals(deal3.getDiscount(), result.getDeals().get(2).getDiscount());
    assertEquals(deal3.getDineIn(), result.getDeals().get(2).getDineIn());
    assertEquals(deal3.getLightning(), result.getDeals().get(2).getLightning());
    assertEquals(deal3.getQtyLeft(), result.getDeals().get(2).getQtyLeft());
  }

  @Test
  void whenGetDealsWithTimeOfDay_thenTwoDealsReturned() {
    Deal deal1 = mockDeal(DEAL_1_OBJECT_ID, DEAL_1_DISCOUNT, DEAL_1_DINE_IN, DEAL_1_OPEN, DEAL_1_CLOSE,
        DEAL_1_LIGHTNING, DEAL_1_QTY_LEFT);
    Deal deal2 = mockDeal(DEAL_2_OBJECT_ID, DEAL_2_DISCOUNT, DEAL_2_DINE_IN, DEAL_2_OPEN, DEAL_2_CLOSE,
        DEAL_2_LIGHTNING, DEAL_2_QTY_LEFT);
    Deal deal3 = mockDeal(DEAL_3_OBJECT_ID, DEAL_3_DISCOUNT, DEAL_3_DINE_IN, DEAL_3_OPEN, DEAL_3_CLOSE,
        DEAL_3_LIGHTNING, DEAL_3_QTY_LEFT);

    Restaurant restaurant1 = mockRestaurant(RESTAURANT_1_OBJECT_ID, RESTAURANT_1_NAME, RESTAURANT_1_ADDRESS_1,
        RESTAURANT_1_SUBURB, RESTAURANT_1_OPEN, RESTAURANT_1_CLOSE, List.of(deal1, deal2));
    Restaurant restaurant2 = mockRestaurant(RESTAURANT_2_OBJECT_ID, RESTAURANT_2_NAME, RESTAURANT_2_ADDRESS_1,
        RESTAURANT_2_SUBURB, RESTAURANT_2_OPEN, RESTAURANT_2_CLOSE, List.of(deal3));

    Restaurants restaurants = mockRestaurants(List.of(restaurant1, restaurant2));

    when(restaurantRestClient.getData(any())).thenReturn(restaurants);

    DealsResponse result = dealService.getDeals(1530);

    // assert deal 1 data
    assertEquals(restaurant1.getObjectId(), result.getDeals().getFirst().getRestaurantObjectId());
    assertEquals(restaurant1.getName(), result.getDeals().getFirst().getRestaurantName());
    assertEquals(restaurant1.getAddress1(), result.getDeals().getFirst().getRestaurantAddress1());
    assertEquals(restaurant1.getSuburb(), result.getDeals().getFirst().getRestaurantSuburb());
    assertEquals(restaurant1.getOpen(), result.getDeals().getFirst().getRestaurantOpen());
    assertEquals(restaurant1.getClose(), result.getDeals().getFirst().getRestaurantClose());
    assertEquals(deal1.getObjectId(), result.getDeals().getFirst().getDealObjectId());
    assertEquals(deal1.getDiscount(), result.getDeals().getFirst().getDiscount());
    assertEquals(deal1.getDineIn(), result.getDeals().getFirst().getDineIn());
    assertEquals(deal1.getLightning(), result.getDeals().getFirst().getLightning());
    assertEquals(deal1.getQtyLeft(), result.getDeals().getFirst().getQtyLeft());

    // assert deal 3 data
    assertEquals(restaurant2.getObjectId(), result.getDeals().get(1).getRestaurantObjectId());
    assertEquals(restaurant2.getName(), result.getDeals().get(1).getRestaurantName());
    assertEquals(restaurant2.getAddress1(), result.getDeals().get(1).getRestaurantAddress1());
    assertEquals(restaurant2.getSuburb(), result.getDeals().get(1).getRestaurantSuburb());
    assertEquals(restaurant2.getOpen(), result.getDeals().get(1).getRestaurantOpen());
    assertEquals(restaurant2.getClose(), result.getDeals().get(1).getRestaurantClose());
    assertEquals(deal3.getObjectId(), result.getDeals().get(1).getDealObjectId());
    assertEquals(deal3.getDiscount(), result.getDeals().get(1).getDiscount());
    assertEquals(deal3.getDineIn(), result.getDeals().get(1).getDineIn());
    assertEquals(deal3.getLightning(), result.getDeals().get(1).getLightning());
    assertEquals(deal3.getQtyLeft(), result.getDeals().get(1).getQtyLeft());
  }

  @Test
  void whenGetDealsWithTimeOfDay_thenNoDealsReturned() {
    Deal deal1 = mockDeal(DEAL_1_OBJECT_ID, DEAL_1_DISCOUNT, DEAL_1_DINE_IN, DEAL_1_OPEN, DEAL_1_CLOSE,
        DEAL_1_LIGHTNING, DEAL_1_QTY_LEFT);
    Deal deal2 = mockDeal(DEAL_2_OBJECT_ID, DEAL_2_DISCOUNT, DEAL_2_DINE_IN, DEAL_2_OPEN, DEAL_2_CLOSE,
        DEAL_2_LIGHTNING, DEAL_2_QTY_LEFT);
    Deal deal3 = mockDeal(DEAL_3_OBJECT_ID, DEAL_3_DISCOUNT, DEAL_3_DINE_IN, DEAL_3_OPEN, DEAL_3_CLOSE,
        DEAL_3_LIGHTNING, DEAL_3_QTY_LEFT);

    Restaurant restaurant1 = mockRestaurant(RESTAURANT_1_OBJECT_ID, RESTAURANT_1_NAME, RESTAURANT_1_ADDRESS_1,
        RESTAURANT_1_SUBURB, RESTAURANT_1_OPEN, RESTAURANT_1_CLOSE, List.of(deal1, deal2));
    Restaurant restaurant2 = mockRestaurant(RESTAURANT_2_OBJECT_ID, RESTAURANT_2_NAME, RESTAURANT_2_ADDRESS_1,
        RESTAURANT_2_SUBURB, RESTAURANT_2_OPEN, RESTAURANT_2_CLOSE, List.of(deal3));

    Restaurants restaurants = mockRestaurants(List.of(restaurant1, restaurant2));

    when(restaurantRestClient.getData(any())).thenReturn(restaurants);

    DealsResponse result = dealService.getDeals(100);

    // assert no deals returned
    assertTrue(result.getDeals().isEmpty());
  }

  @Test
  void whenGetPeakTimeWithSinglePeak_thenOnePeakReturned() {
    Deal deal1 = mockDeal(DEAL_1_OBJECT_ID, DEAL_1_DISCOUNT, DEAL_1_DINE_IN, DEAL_1_OPEN, DEAL_1_CLOSE,
        DEAL_1_LIGHTNING, DEAL_1_QTY_LEFT);
    Deal deal2 = mockDeal(DEAL_2_OBJECT_ID, DEAL_2_DISCOUNT, DEAL_2_DINE_IN, DEAL_2_OPEN, DEAL_2_CLOSE,
        DEAL_2_LIGHTNING, DEAL_2_QTY_LEFT);
    Deal deal3 = mockDeal(DEAL_3_OBJECT_ID, DEAL_3_DISCOUNT, DEAL_3_DINE_IN, DEAL_3_OPEN, DEAL_3_CLOSE,
        DEAL_3_LIGHTNING, DEAL_3_QTY_LEFT);
    Deal deal4 = mockDeal(DEAL_4_OBJECT_ID, DEAL_4_DISCOUNT, DEAL_4_DINE_IN, DEAL_4_OPEN, DEAL_4_CLOSE,
        DEAL_4_LIGHTNING, DEAL_4_QTY_LEFT);

    Restaurant restaurant1 = mockRestaurant(RESTAURANT_1_OBJECT_ID, RESTAURANT_1_NAME, RESTAURANT_1_ADDRESS_1,
        RESTAURANT_1_SUBURB, RESTAURANT_1_OPEN, RESTAURANT_1_CLOSE, List.of(deal1, deal2));
    Restaurant restaurant2 = mockRestaurant(RESTAURANT_2_OBJECT_ID, RESTAURANT_2_NAME, RESTAURANT_2_ADDRESS_1,
        RESTAURANT_2_SUBURB, RESTAURANT_2_OPEN, RESTAURANT_2_CLOSE, List.of(deal3, deal4));

    Restaurants restaurants = mockRestaurants(List.of(restaurant1, restaurant2));

    when(restaurantRestClient.getData(any())).thenReturn(restaurants);

    PeakTimeResponse result = dealService.getPeakTime();

    assertEquals("3:00pm", result.getPeakTimeStart());
    assertEquals("4:00pm", result.getPeakTimeEnd());
  }

  @Test
  void whenGetPeakTimeWithMultiplePeaksOfSameValue_thenLongestPeakReturned() {
    Deal deal1 = mockDeal(DEAL_1_OBJECT_ID, DEAL_1_DISCOUNT, DEAL_1_DINE_IN, DEAL_1_OPEN, DEAL_1_CLOSE,
        DEAL_1_LIGHTNING, DEAL_1_QTY_LEFT);
    Deal deal2 = mockDeal(DEAL_2_OBJECT_ID, DEAL_2_DISCOUNT, DEAL_2_DINE_IN, DEAL_2_OPEN, DEAL_2_CLOSE,
        DEAL_2_LIGHTNING, DEAL_2_QTY_LEFT);
    Deal deal3 = mockDeal(DEAL_3_OBJECT_ID, DEAL_3_DISCOUNT, DEAL_3_DINE_IN, DEAL_3_OPEN, DEAL_3_CLOSE,
        DEAL_3_LIGHTNING, DEAL_3_QTY_LEFT);
    Deal deal4 = mockDeal(DEAL_4_OBJECT_ID, DEAL_4_DISCOUNT, DEAL_4_DINE_IN, DEAL_4_OPEN, DEAL_4_CLOSE,
        DEAL_4_LIGHTNING, DEAL_4_QTY_LEFT);
    Deal deal5 = mockDeal(DEAL_5_OBJECT_ID, DEAL_5_DISCOUNT, DEAL_5_DINE_IN, DEAL_5_OPEN, DEAL_5_CLOSE,
        DEAL_5_LIGHTNING, DEAL_5_QTY_LEFT);
    Deal deal6 = mockDeal(DEAL_6_OBJECT_ID, DEAL_6_DISCOUNT, DEAL_6_DINE_IN, DEAL_6_OPEN, DEAL_6_CLOSE,
        DEAL_6_LIGHTNING, DEAL_6_QTY_LEFT);

    Restaurant restaurant1 = mockRestaurant(RESTAURANT_1_OBJECT_ID, RESTAURANT_1_NAME, RESTAURANT_1_ADDRESS_1,
        RESTAURANT_1_SUBURB, RESTAURANT_1_OPEN, RESTAURANT_1_CLOSE, List.of(deal1, deal2));
    Restaurant restaurant2 = mockRestaurant(RESTAURANT_2_OBJECT_ID, RESTAURANT_2_NAME, RESTAURANT_2_ADDRESS_1,
        RESTAURANT_2_SUBURB, RESTAURANT_2_OPEN, RESTAURANT_2_CLOSE, List.of(deal3, deal4));
    Restaurant restaurant3 = mockRestaurant(RESTAURANT_3_OBJECT_ID, RESTAURANT_3_NAME, RESTAURANT_3_ADDRESS_1,
        RESTAURANT_3_SUBURB, RESTAURANT_3_OPEN, RESTAURANT_3_CLOSE, List.of(deal5, deal6));

    Restaurants restaurants = mockRestaurants(List.of(restaurant1, restaurant2, restaurant3));

    when(restaurantRestClient.getData(any())).thenReturn(restaurants);

    PeakTimeResponse result = dealService.getPeakTime();

    assertEquals("6:00pm", result.getPeakTimeStart());
    assertEquals("8:00pm", result.getPeakTimeEnd());
  }

  @Test
  void whenGetPeakTimeWithMultiplePeaks_thenHighestButNotLongestPeakReturned() {
    Deal deal1 = mockDeal(DEAL_1_OBJECT_ID, DEAL_1_DISCOUNT, DEAL_1_DINE_IN, DEAL_1_OPEN, DEAL_1_CLOSE,
        DEAL_1_LIGHTNING, DEAL_1_QTY_LEFT);
    Deal deal2 = mockDeal(DEAL_2_OBJECT_ID, DEAL_2_DISCOUNT, DEAL_2_DINE_IN, DEAL_2_OPEN, DEAL_2_CLOSE,
        DEAL_2_LIGHTNING, DEAL_2_QTY_LEFT);
    Deal deal3 = mockDeal(DEAL_3_OBJECT_ID, DEAL_3_DISCOUNT, DEAL_3_DINE_IN, DEAL_3_OPEN, DEAL_3_CLOSE,
        DEAL_3_LIGHTNING, DEAL_3_QTY_LEFT);
    Deal deal4 = mockDeal(DEAL_4_OBJECT_ID, DEAL_4_DISCOUNT, DEAL_4_DINE_IN, DEAL_4_OPEN, DEAL_4_CLOSE,
        DEAL_4_LIGHTNING, DEAL_4_QTY_LEFT);
    Deal deal5 = mockDeal(DEAL_5_OBJECT_ID, DEAL_5_DISCOUNT, DEAL_5_DINE_IN, DEAL_5_OPEN, DEAL_5_CLOSE,
        DEAL_5_LIGHTNING, DEAL_5_QTY_LEFT);
    Deal deal6 = mockDeal(DEAL_6_OBJECT_ID, DEAL_6_DISCOUNT, DEAL_6_DINE_IN, DEAL_6_OPEN, DEAL_6_CLOSE,
        DEAL_6_LIGHTNING, DEAL_6_QTY_LEFT);

    Deal deal7 = mockDeal(DEAL_7_OBJECT_ID, DEAL_7_DISCOUNT, DEAL_7_DINE_IN, DEAL_7_OPEN, DEAL_7_CLOSE,
        DEAL_7_LIGHTNING, DEAL_7_QTY_LEFT);
    Deal deal8 = mockDeal(DEAL_8_OBJECT_ID, DEAL_8_DISCOUNT, DEAL_8_DINE_IN, DEAL_8_OPEN, DEAL_8_CLOSE,
        DEAL_8_LIGHTNING, DEAL_8_QTY_LEFT);
    Deal deal9 = mockDeal(DEAL_9_OBJECT_ID, DEAL_9_DISCOUNT, DEAL_9_DINE_IN, DEAL_9_OPEN, DEAL_9_CLOSE,
        DEAL_9_LIGHTNING, DEAL_9_QTY_LEFT);

    Restaurant restaurant1 = mockRestaurant(RESTAURANT_1_OBJECT_ID, RESTAURANT_1_NAME, RESTAURANT_1_ADDRESS_1,
        RESTAURANT_1_SUBURB, RESTAURANT_1_OPEN, RESTAURANT_1_CLOSE, List.of(deal1, deal2));
    Restaurant restaurant2 = mockRestaurant(RESTAURANT_2_OBJECT_ID, RESTAURANT_2_NAME, RESTAURANT_2_ADDRESS_1,
        RESTAURANT_2_SUBURB, RESTAURANT_2_OPEN, RESTAURANT_2_CLOSE, List.of(deal3, deal4));
    Restaurant restaurant3 = mockRestaurant(RESTAURANT_3_OBJECT_ID, RESTAURANT_3_NAME, RESTAURANT_3_ADDRESS_1,
        RESTAURANT_3_SUBURB, RESTAURANT_3_OPEN, RESTAURANT_3_CLOSE, List.of(deal5, deal6));
    Restaurant restaurant4 = mockRestaurant(RESTAURANT_4_OBJECT_ID, RESTAURANT_4_NAME, RESTAURANT_4_ADDRESS_1,
        RESTAURANT_4_SUBURB, RESTAURANT_4_OPEN, RESTAURANT_4_CLOSE, List.of(deal7, deal8, deal9));

    Restaurants restaurants = mockRestaurants(List.of(restaurant1, restaurant2, restaurant3, restaurant4));

    when(restaurantRestClient.getData(any())).thenReturn(restaurants);

    PeakTimeResponse result = dealService.getPeakTime();

    assertEquals("4:30pm", result.getPeakTimeStart());
    assertEquals("5:00pm", result.getPeakTimeEnd());
  }

  @Test
  void whenGetPeakTimeWithSingleDeal_thenEntireDealDurationAsPeakReturned() {
    Deal deal1 = mockDeal(DEAL_1_OBJECT_ID, DEAL_1_DISCOUNT, DEAL_1_DINE_IN, DEAL_1_OPEN, DEAL_1_CLOSE,
        DEAL_1_LIGHTNING, DEAL_1_QTY_LEFT);

    Restaurant restaurant1 = mockRestaurant(RESTAURANT_1_OBJECT_ID, RESTAURANT_1_NAME, RESTAURANT_1_ADDRESS_1,
        RESTAURANT_1_SUBURB, RESTAURANT_1_OPEN, RESTAURANT_1_CLOSE, List.of(deal1));

    Restaurants restaurants = mockRestaurants(List.of(restaurant1));

    when(restaurantRestClient.getData(any())).thenReturn(restaurants);

    PeakTimeResponse result = dealService.getPeakTime();

    assertEquals("3:00pm", result.getPeakTimeStart());
    assertEquals("8:00pm", result.getPeakTimeEnd());
  }

  @Test
  void whenGetPeakTime_thenNoPeakExistsOrReturned() {
    Restaurants restaurants = mockRestaurants(Collections.emptyList());

    when(restaurantRestClient.getData(any())).thenReturn(restaurants);

    assertThrows(PeakNotFoundException.class, () -> dealService.getPeakTime());
  }
}
