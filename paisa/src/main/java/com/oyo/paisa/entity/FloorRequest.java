package com.oyo.paisa.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "floor_requests")
public class FloorRequest implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "req_id")
    @JsonProperty("req_id")
    private Integer reqId;

    @JsonProperty("hotel_id")
    @Column(name = "hotel_id")
    private Integer hotelId;

    @JsonProperty("rc_id")
    @Column(name = "rc_id")
    private Integer rcId;

    @JsonProperty("prices")
    @Column(name = "prices")
    private String prices;



}
