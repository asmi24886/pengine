package com.test.pengine.service;

import com.test.pengine.models.CheckoutRequest;
import com.test.pengine.parser.RuleParserEngine;
import com.test.pengine.repository.ItemPriceDao;
import com.test.pengine.repository.PromotionRulesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

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
