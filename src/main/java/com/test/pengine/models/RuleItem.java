package com.test.pengine.models;

public class RuleItem {
    private String skuId;
    private int count;

    public RuleItem(String skuId, int count) {
        this.skuId = skuId;
        this.count = count;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "RuleItem{" +
                "skuId='" + skuId + '\'' +
                ", count=" + count +
                '}';
    }
}
