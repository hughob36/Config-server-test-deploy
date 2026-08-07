package com.conveter.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

//@FeignClient(name = "exchange-service")
@FeignClient(
        name = "exchange-service",
        url = "${EXCHANGE_SERVICE_URL:https://stunning-celebration-production-3657.up.railway.app}"
)
public interface ExchangeClient {

    @GetMapping("/api/rate")
    Map<String, Double> getRate();
}
