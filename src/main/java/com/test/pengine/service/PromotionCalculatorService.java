package com.test.pengine.service;

import com.test.pengine.models.CheckoutRequest;
import com.test.pengine.parser.RuleParserEngine;
import org.springframework.stereotype.Service;

@Service
public class PromotionCalculatorService {

    public double getTotalAmountAfterPromotions(CheckoutRequest request) {

        RuleParserEngine parser = new RuleParserEngine();
        return parser
                .setItemQuantityMap(request.getItemQuantityMap())
                .setPriceMap(request.getPriceMap())
                .setRules(request.getRules())
                .parseAndCalculate();
    }
}
