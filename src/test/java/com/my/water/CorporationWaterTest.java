package com.my.water;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CorporationWaterTest {
    private final CorporationWater objectUnderTest = CorporationWater.instance;

    @Test
    public void shouldReturnCorrectPrices() {
        List<Price> actualPrices = objectUnderTest.getPrices();

        assertThat(actualPrices).asList().containsExactly(new Price(0, Integer.MAX_VALUE, 1.0));
    }

    @Test
    public void shouldReturnCorrectCost() {
        assertThat(objectUnderTest.totalCost(1000.0)).isEqualTo(1000.0);
        assertThat(objectUnderTest.totalCost(0.0)).isEqualTo(0.0);
    }
}
