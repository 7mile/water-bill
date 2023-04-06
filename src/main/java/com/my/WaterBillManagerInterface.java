package com.my;

import com.my.water.WaterUsage;

import java.util.List;

public interface WaterBillManagerInterface {

    void add(List<WaterUsage> waterUsageList);

    long getTotalWaterUsageInLiter();

    long getTotalWaterCost();
}
