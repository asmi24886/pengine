package com.test.pengine.models;

import com.test.pengine.plugins.IRuleParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A Rule is supposed to take the items included in this rule. The apply method is extended from Rule parser interface
 * This interface will is extensible and can work as a plugin system for future use
 *
 */
public class Rule implements IRuleParser {

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

    @Override
    public double apply(Map<String, Integer> itemQuantityMap) {
        Map<String, Integer> itemBundleCountByItemIdInRule = new HashMap<String, Integer>();

        List<RuleItem> ruleItems = this.getRuleItems();

        int leastBundleCount = 0;
        String leastBundleCountId = "";

        for(RuleItem ruleItem : ruleItems) {
            String itemid = ruleItem.getSkuId();
            int itemCount = itemQuantityMap.get(itemid) == null ? 0 : itemQuantityMap.get(itemid);
            if(itemCount == 0 || itemCount < ruleItem.getCount()) { //rule not applicable
                System.out.println("[DEBUG : This rule cannot be applied due to constraints not matching.]");
                return 0;
            }

            int bundleCount = itemCount/ruleItem.getCount();
            if(leastBundleCount == 0 || bundleCount < leastBundleCount) {
                leastBundleCount = bundleCount;
                leastBundleCountId = itemid;
            }

            itemBundleCountByItemIdInRule.put(itemid, bundleCount);
        }

        double totalPriceForThisRule = leastBundleCount*this.getRulePrice();

        for(RuleItem ruleItem : ruleItems) {
            itemQuantityMap.put(ruleItem.getSkuId(), itemQuantityMap.get(ruleItem.getSkuId()) - (leastBundleCount*ruleItem.getCount())); //These many were calculated by this rule
        }

        return totalPriceForThisRule;
    }
}
