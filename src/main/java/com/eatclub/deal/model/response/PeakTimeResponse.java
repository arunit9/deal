package com.eatclub.deal.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PeakTimeResponse {
  private String peakTimeStart;
  private String peakTimeEnd;
}
