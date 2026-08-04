package com.conveter.service.controller;

import com.conveter.service.client.ExchangeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ConverterController {

    @Autowired
    private ExchangeClient exchangeClient;

    @GetMapping("/convert")
    public ResponseEntity<Map<String, Object>> convert(@RequestParam Double amount) {

        Map<String, Double> response = exchangeClient.getRate();
        Double rate = response.get("rate");

        Double total = amount * rate;

        Map<String, Object> result = new HashMap<>();
        result.put("amount", amount);
        result.put("rate", rate);
        result.put("total", total);

        return ResponseEntity.ok(result);
    }

}
