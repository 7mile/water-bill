package com.my.water;

import java.util.ArrayList;
import java.util.List;

public class TankerWater implements Water {
    private static List<Price> prices;

    static {
        prices = new ArrayList<>();
        prices.add(new Price(0, 500, 2.0));
        prices.add(new Price(501, 1500, 3.0));
        prices.add(new Price(1501, 3000, 5.0));
        prices.add(new Price(3001, Integer.MAX_VALUE, 8.0));
    }

    public static TankerWater instance = new TankerWater();

    private TankerWater() {
    }

    @Override
    public List<Price> getPrices() {
        return prices;
    }
}