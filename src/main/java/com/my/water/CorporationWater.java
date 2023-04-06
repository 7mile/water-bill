package com.my.water;

import java.util.ArrayList;
import java.util.List;

public class CorporationWater implements Water {
    private static List<Price> prices;

    static {
        prices = new ArrayList<>();
        prices.add(new Price(0, Integer.MAX_VALUE, 1.0));
    }

    public static CorporationWater instance = new CorporationWater();

    private CorporationWater() {

    }

    @Override
    public List<Price> getPrices() {
        return prices;
    }
}
