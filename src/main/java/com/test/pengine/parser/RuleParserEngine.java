package com.test.pengine.parser;

import com.test.pengine.models.Rule;

import java.util.*;

public class RuleParserEngine {

    private List<Rule> rules = new ArrayList<Rule>();
    private Map<String, Double> priceMap = new HashMap<String, Double>();
    private Map<String, Integer> itemQuantityMap = new HashMap<String, Integer>();

    public RuleParserEngine setRules(List<Rule> rules) {
        if(rules != null)
            this.rules = rules;

        return this;
    }

    public RuleParserEngine setPriceMap(Map<String, Double> priceMap) {
        if(priceMap != null)
            this.priceMap = priceMap;

        return this;
    }

    public RuleParserEngine setItemQuantityMap(Map<String, Integer> itemQuantityMap) {
        if(itemQuantityMap != null)
            this.itemQuantityMap = itemQuantityMap;

        return this;
    }

    public double parseAndCalculate() {

        Iterator<Rule> it = rules.iterator();
        double total = 0;

        while(it.hasNext()) {total+=it.next().apply(this.itemQuantityMap);}

        Set<Map.Entry<String, Integer>> entries = itemQuantityMap.entrySet();

        for(Map.Entry<String, Integer> e : entries) {
            System.out.println(e);
            total+= e.getValue()*priceMap.get(e.getKey());
        }

        return total;
    }
}
