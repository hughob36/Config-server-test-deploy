package com.exchange_service.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RateController {

    @GetMapping("/rate")
    public ResponseEntity<Map<String,Double>> getRate() {

        Map<String,Double> rateMap = new HashMap<>();
        rateMap.put("rate",1500.0);

        return ResponseEntity.ok(rateMap);
    }
}
