package com.oyo.paisa.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsumerPriceGetResponse {


    @JsonProperty("hotel_id")
    private Integer hotelId;

    @JsonProperty("rc_id")
    private Integer rcId;

    @JsonProperty("prices")
    private Map<String,Double> prices;
}
