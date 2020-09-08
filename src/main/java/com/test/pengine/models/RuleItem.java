package com.test.pengine.models;

public class RuleItem {
    private String skuId;
    private int count;

    //Any future operation on the item itself can be placed here like calculating percentage on a particular item price.
    // Implementation of Apply method on Rule class will help.
    private String itemOperation;

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

    public String getItemOperation() {
        return itemOperation;
    }

    public void setItemOperation(String itemOperation) {
        this.itemOperation = itemOperation;
    }

    @Override
    public String toString() {
        return "RuleItem{" +
                "skuId='" + skuId + '\'' +
                ", count=" + count +
                ", itemOperation='" + itemOperation + '\'' +
                '}';
    }
}
