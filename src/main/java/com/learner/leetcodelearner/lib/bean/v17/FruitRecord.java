package com.learner.leetcodelearner.lib.bean.v17;

public record FruitRecord(String name, int price) {

    public FruitRecord {
        System.out.println("name"+ name +  "price" + price);
        if (name == null) {
            throw new IllegalArgumentException("name not be null");
        }
    }
}
