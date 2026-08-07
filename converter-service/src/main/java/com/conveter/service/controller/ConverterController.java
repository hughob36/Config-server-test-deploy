package com.conveter.service.controller;

import com.conveter.service.client.ExchangeClient;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class ConverterController {


    private final ExchangeClient exchangeClient;

    @GetMapping("/convert")
    public ResponseEntity<?> convert(@RequestParam Double amount) {

        Map<String, Double> response = exchangeClient.getRate();

        // Validar si la respuesta o la clave son nulas
        if (response == null || !response.containsKey("rate") || response.get("rate") == null) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "No se pudo obtener la tasa desde exchange-service. Verifica la estructura del JSON respuesta.");
            return ResponseEntity.status(500).body(error);
        }

        Double rate = response.get("rate");
        Double total = amount * rate;

        Map<String, Object> result = new HashMap<>();
        result.put("amount", amount);
        result.put("rate", rate);
        result.put("total", total);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/hola")
    public ResponseEntity<String> hola() {
        return ResponseEntity.ok("Hola");
    }

}
