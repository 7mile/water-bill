package com.my.water;

import java.util.List;

public interface Water {
    List<Price> getPrices();

    default double totalCost(Double waterInLiter) {
        return getPrices()
                .stream()
                .filter(price -> waterInLiter >= price.getStart())
                .map(price -> {
                    double amount;
                    if (price.getEnd() >= waterInLiter) {
                        amount = price.getStart() > 1 ? waterInLiter - (price.getStart() - 1) : waterInLiter - price.getStart();
                    } else {
                        amount = price.getStart() > 1 ? price.getEnd() - (price.getStart() - 1) : price.getEnd() - price.getStart();
                    }
                    return amount * price.getPrice();
                })
                .reduce(Double::sum)
                .orElse(0.0);
    }
}
