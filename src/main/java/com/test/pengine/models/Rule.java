package com.test.pengine.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *
 */
public class Rule {

    private double rulePrice;
    private List<RuleItem> ruleItems;


    public double getRulePrice() {
        return rulePrice;
    }

    public void setRulePrice(double rulePrice) {
        this.rulePrice = rulePrice;
    }

    public List<RuleItem> getRuleItems() {
        return ruleItems;
    }

    public void setRuleItems(List<RuleItem> ruleItems) {
        this.ruleItems = ruleItems;
    }

    @Override
    public String toString() {
        return "Rule{" +

                ", rulePrice=" + rulePrice +
                ", ruleItems=" + ruleItems +
                '}';
    }

    public double apply(Map<String, Integer> itemQuantityMap) {return 0;}
}
