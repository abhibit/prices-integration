package com.oyo.paisa.controller;


import com.oyo.paisa.cache.RmsCache;
import com.oyo.paisa.entity.FloorRequest;
import com.oyo.paisa.request.ConsumerPricePostRequest;
import com.oyo.paisa.response.ConsumerPriceGetResponse;
import com.oyo.paisa.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @Autowired
    RmsCache rmsCache;
    @PostMapping(value = "/post")
    public FloorRequest postData(@RequestBody ConsumerPricePostRequest floorRequest) {
       return  testService.postFloorRequest(floorRequest);
    }

    @GetMapping(value = "/get")
    public List<FloorRequest> postData() {
        return  testService.getFloorRequestByHotelId(23);
    }


    @GetMapping(value = "/getdata")
    public ConsumerPriceGetResponse getData() {
        return  testService.getFloorRequest(10);
    }

    @GetMapping(value="redis")
    public Object getAuth(){
        Long time=10000L;
        rmsCache.set("TEST_KEY","TEST_VALUE",time);
        return rmsCache.get("TEST_KEY");
    }

    }
