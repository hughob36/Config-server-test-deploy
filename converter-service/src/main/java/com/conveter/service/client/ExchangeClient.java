package com.conveter.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(name = "EXCHANGE-SERVICE")
public interface ExchangeClient {

    @GetMapping("/api/rate")
    Map<String, Double> getRate();
}
