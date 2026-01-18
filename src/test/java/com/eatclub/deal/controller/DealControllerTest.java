package com.eatclub.deal.controller;

import static com.eatclub.deal.mock.data.DealMockData.DEAL_1_DINE_IN;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_1_DISCOUNT;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_1_LIGHTNING;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_1_OBJECT_ID;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_1_QTY_LEFT;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_2_DINE_IN;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_2_DISCOUNT;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_2_LIGHTNING;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_2_OBJECT_ID;
import static com.eatclub.deal.mock.data.DealMockData.DEAL_2_QTY_LEFT;
import static com.eatclub.deal.mock.data.DealMockData.PEAK_TIME_END;
import static com.eatclub.deal.mock.data.DealMockData.PEAK_TIME_START;
import static com.eatclub.deal.mock.data.DealMockData.RESTAURANT_ADDRESS_1;
import static com.eatclub.deal.mock.data.DealMockData.RESTAURANT_CLOSE;
import static com.eatclub.deal.mock.data.DealMockData.RESTAURANT_NAME;
import static com.eatclub.deal.mock.data.DealMockData.RESTAURANT_OBJECT_ID;
import static com.eatclub.deal.mock.data.DealMockData.RESTAURANT_OPEN;
import static com.eatclub.deal.mock.data.DealMockData.RESTAURANT_SUBURB;
import static com.eatclub.deal.mock.data.DealMockData.TIME_PARAM;
import static com.eatclub.deal.mock.data.DealMockData.mockDealResponse;
import static com.eatclub.deal.mock.data.DealMockData.mockDealsResponse;
import static com.eatclub.deal.mock.data.DealMockData.mockPeakTimeResponse;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

import com.eatclub.deal.service.DealService;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(DealController.class)
class DealControllerTest {

  private final MockMvc mockMvc;

  @MockitoBean
  private DealService dealService;

  @Autowired
  public DealControllerTest(MockMvc mockMvc) {
    this.mockMvc = mockMvc;
  }

  @Test
  void whenGetDealsWithoutTimeOfDay_thenTwoDealsReturnedWithStatusOk() throws Exception {

    when(dealService.getDeals(null)).thenReturn(mockDealsResponse(List.of(
        mockDealResponse(DEAL_1_OBJECT_ID, DEAL_1_DISCOUNT, DEAL_1_DINE_IN, DEAL_1_LIGHTNING, DEAL_1_QTY_LEFT),
        mockDealResponse(DEAL_2_OBJECT_ID, DEAL_2_DISCOUNT, DEAL_2_DINE_IN, DEAL_2_LIGHTNING, DEAL_2_QTY_LEFT))));

    mockMvc.perform(get("/api/deals")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.deals").isArray())
        .andExpect(jsonPath("$.deals", hasSize(2)))
        .andExpect(jsonPath("$.deals[0].restaurantObjectId").value(RESTAURANT_OBJECT_ID))
        .andExpect(jsonPath("$.deals[0].restaurantName").value(RESTAURANT_NAME))
        .andExpect(jsonPath("$.deals[0].restaurantAddress1").value(RESTAURANT_ADDRESS_1))
        .andExpect(jsonPath("$.deals[0].restaurantSuburb").value(RESTAURANT_SUBURB))
        .andExpect(jsonPath("$.deals[0].restaurantOpen").value(RESTAURANT_OPEN))
        .andExpect(jsonPath("$.deals[0].restaurantClose").value(RESTAURANT_CLOSE))
        .andExpect(jsonPath("$.deals[0].dealObjectId").value(DEAL_1_OBJECT_ID))
        .andExpect(jsonPath("$.deals[0].discount").value(DEAL_1_DISCOUNT))
        .andExpect(jsonPath("$.deals[0].dineIn").value(DEAL_1_DINE_IN))
        .andExpect(jsonPath("$.deals[0].lightning").value(DEAL_1_LIGHTNING))
        .andExpect(jsonPath("$.deals[0].qtyLeft").value(DEAL_1_QTY_LEFT))
        .andExpect(jsonPath("$.deals[1].restaurantObjectId").value(RESTAURANT_OBJECT_ID))
        .andExpect(jsonPath("$.deals[1].restaurantName").value(RESTAURANT_NAME))
        .andExpect(jsonPath("$.deals[1].restaurantAddress1").value(RESTAURANT_ADDRESS_1))
        .andExpect(jsonPath("$.deals[1].restaurantSuburb").value(RESTAURANT_SUBURB))
        .andExpect(jsonPath("$.deals[1].restaurantOpen").value(RESTAURANT_OPEN))
        .andExpect(jsonPath("$.deals[1].restaurantClose").value(RESTAURANT_CLOSE))
        .andExpect(jsonPath("$.deals[1].dealObjectId").value(DEAL_2_OBJECT_ID))
        .andExpect(jsonPath("$.deals[1].discount").value(DEAL_2_DISCOUNT))
        .andExpect(jsonPath("$.deals[1].dineIn").value(DEAL_2_DINE_IN))
        .andExpect(jsonPath("$.deals[1].lightning").value(DEAL_2_LIGHTNING))
        .andExpect(jsonPath("$.deals[1].qtyLeft").value(DEAL_2_QTY_LEFT));
  }

  @Test
  void whenGetDealsWithTimeOfDay_thenOneDealReturnedWithStatusOk() throws Exception {

    when(dealService.getDeals(anyString())).thenReturn(mockDealsResponse(List.of(
        mockDealResponse(DEAL_1_OBJECT_ID, DEAL_1_DISCOUNT, DEAL_1_DINE_IN, DEAL_1_LIGHTNING, DEAL_1_QTY_LEFT))));

    mockMvc.perform(get("/api/deals")
            .param(TIME_PARAM, "3:00pm")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.deals").isArray())
        .andExpect(jsonPath("$.deals", hasSize(1)))
        .andExpect(jsonPath("$.deals[0].restaurantObjectId").value(RESTAURANT_OBJECT_ID))
        .andExpect(jsonPath("$.deals[0].restaurantName").value(RESTAURANT_NAME))
        .andExpect(jsonPath("$.deals[0].restaurantAddress1").value(RESTAURANT_ADDRESS_1))
        .andExpect(jsonPath("$.deals[0].restaurantSuburb").value(RESTAURANT_SUBURB))
        .andExpect(jsonPath("$.deals[0].restaurantOpen").value(RESTAURANT_OPEN))
        .andExpect(jsonPath("$.deals[0].restaurantClose").value(RESTAURANT_CLOSE))
        .andExpect(jsonPath("$.deals[0].dealObjectId").value(DEAL_1_OBJECT_ID))
        .andExpect(jsonPath("$.deals[0].discount").value(DEAL_1_DISCOUNT))
        .andExpect(jsonPath("$.deals[0].dineIn").value(DEAL_1_DINE_IN))
        .andExpect(jsonPath("$.deals[0].lightning").value(DEAL_1_LIGHTNING))
        .andExpect(jsonPath("$.deals[0].qtyLeft").value(DEAL_1_QTY_LEFT));
  }

  @Test
  void whenGetDealsWithTimeOfDay_NoDealsReturnedWithStatusOk() throws Exception {

    when(dealService.getDeals(anyString())).thenReturn(mockDealsResponse(Collections.emptyList()));

    mockMvc.perform(get("/api/deals")
            .param(TIME_PARAM, "10:00am")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.deals").isEmpty());
  }

  @Test
  void whenGetPeakTime_thenDataReturnedWithStatusOk() throws Exception {

    when(dealService.getPeakTime()).thenReturn(mockPeakTimeResponse());

    mockMvc.perform(get("/api/deals/peak")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.peakTimeStart").value(PEAK_TIME_START))
        .andExpect(jsonPath("$.peakTimeEnd").value(PEAK_TIME_END));
  }
}
