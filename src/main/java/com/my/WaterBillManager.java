package com.my;

import com.my.water.WaterUsage;

import java.util.ArrayList;
import java.util.List;

public class WaterBillManager implements WaterBillManagerInterface {
    private List<WaterUsage> waterUsages;


    public WaterBillManager() {
        waterUsages = new ArrayList<>();
    }

    @Override
    public void add(List<WaterUsage> waterUsageList) {
        waterUsages.addAll(waterUsageList);
    }

    @Override
    public long getTotalWaterUsageInLiter() {
        return waterUsages.stream()
                .map(waterUsage -> waterUsage.getLiter())
                .map(Math::round)
                .reduce(0L, Long::sum);
    }

    @Override
    public long getTotalWaterCost() {
        return waterUsages.stream()
                .map(waterUsage -> waterUsage.getWater().totalCost(waterUsage.getLiter()))
                .map(Math::round)
                .reduce(0L, Long::sum);
    }
}
