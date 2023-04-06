package com.my.water;

import java.util.ArrayList;
import java.util.List;

public class BorewellWater implements Water {
    private static List<Price> prices;

    static {
        prices = new ArrayList<>();
        prices.add(new Price(0, Integer.MAX_VALUE, 1.5));
    }

    public static BorewellWater instance = new BorewellWater();

    private BorewellWater() {
    }

    @Override
    public List<Price> getPrices() {
        return prices;
    }
}