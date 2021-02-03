package com.oyo.paisa.service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.oyo.paisa.entity.FloorRequest;
import com.oyo.paisa.repo.FloorRequestRepo;
import com.oyo.paisa.request.ConsumerPricePostRequest;
import com.oyo.paisa.response.ConsumerPriceGetResponse;
import com.oyo.paisa.util.TransformUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TestService {
    @Autowired
    FloorRequestRepo floorRequestRepo;

    public FloorRequest postFloorRequest(ConsumerPricePostRequest consumerPricePostRequest)
    {
        FloorRequest floorRequest=new FloorRequest();
        floorRequest.setRcId(consumerPricePostRequest.getRcId());
        floorRequest.setHotelId(consumerPricePostRequest.getHotelId());
        floorRequest.setPrices(TransformUtil.toJson(consumerPricePostRequest.getPrices()));
        return floorRequestRepo.save(floorRequest);
    }
    public List<FloorRequest> getFloorRequestByHotelId(Integer hotelId)
    {
        return floorRequestRepo.findAllByHotelIds(hotelId);
    }

    public ConsumerPriceGetResponse getFloorRequest(Integer hotelId)
    {
       FloorRequest floorRequest= floorRequestRepo.findByReqId(10);
       ConsumerPriceGetResponse consumerPriceGetResponse=new ConsumerPriceGetResponse();
       consumerPriceGetResponse.setHotelId(floorRequest.getHotelId());
       consumerPriceGetResponse.setRcId(floorRequest.getRcId());
        Map<String,Double>priceMap=(Map<String, Double>)TransformUtil.fromJson(floorRequest.getPrices(), new TypeReference<Map<String, Double>>() {});
        consumerPriceGetResponse.setPrices(priceMap);
        return consumerPriceGetResponse;
    }
}
