package com.oyo.paisa.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsumerPricePostRequest {


    @JsonProperty("hotel_id")
    private Integer hotelId;

    @JsonProperty("rc_id")
    private Integer rcId;

    @JsonProperty("prices")
    private Map<String,Double> prices;
}
