package com.my.water;

public class WaterUsage {
    private Water water;
    private double liter;

    public WaterUsage(Water water, double liter) {
        this.water = water;
        this.liter = liter;
    }

    public Water getWater() {
        return water;
    }

    public double getLiter() {
        return liter;
    }
}
