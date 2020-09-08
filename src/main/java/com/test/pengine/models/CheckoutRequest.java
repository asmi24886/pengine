package com.test.pengine.models;

import java.util.List;
import java.util.Map;

public class CheckoutRequest {
    Map<String, Integer> itemQuantityMap;
    Map<String, Double> priceMap;
    List<Rule> rules;

    public Map<String, Integer> getItemQuantityMap() {
        return itemQuantityMap;
    }

    public void setItemQuantityMap(Map<String, Integer> itemQuantityMap) {
        this.itemQuantityMap = itemQuantityMap;
    }

    public Map<String, Double> getPriceMap() {
        return priceMap;
    }

    public void setPriceMap(Map<String, Double> priceMap) {
        this.priceMap = priceMap;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    @Override
    public String toString() {
        return "CheckoutRequest{" +
                "itemQuantityMap=" + itemQuantityMap +
                ", priceMap=" + priceMap +
                ", rules=" + rules +
                '}';
    }
}
