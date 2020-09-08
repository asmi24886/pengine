package com.test.pengine.controller;

import com.test.pengine.models.CheckoutRequest;
import com.test.pengine.models.CheckoutResponse;
import com.test.pengine.service.PromotionCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PromotionEngineController {

    @Autowired
    private PromotionCalculatorService service;

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public ResponseEntity<?> getTotalPriceAfterAppliedPromotion(@RequestBody CheckoutRequest request) {
        double totalPrice = service.getTotalAmountAfterPromotions(request);
        CheckoutResponse response = new CheckoutResponse();
        response.setTotalPrice(totalPrice);
        return ResponseEntity.ok(response);
    }
}
