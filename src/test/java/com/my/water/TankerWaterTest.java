package com.my.water;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TankerWaterTest {
    private final TankerWater objectUnderTest = TankerWater.instance;

    @Test
    public void shouldReturnCorrectPrices() {
        List<Price> actualPrices = objectUnderTest.getPrices();

        assertThat(actualPrices).asList().containsExactly(
                new Price(0, 500, 2.0),
                new Price(501, 1500, 3.0),
                new Price(1501, 3000, 5.0),
                new Price(3001, Integer.MAX_VALUE, 8.0)
        );
    }

    @Test
    public void shouldReturnCorrectCost() {
        assertThat(objectUnderTest.totalCost(0.0)).isEqualTo(0.0);
        assertThat(objectUnderTest.totalCost(500.0)).isEqualTo(1000.0);
        assertThat(objectUnderTest.totalCost(501.0)).isEqualTo(1003.0);
        assertThat(objectUnderTest.totalCost(1500.0)).isEqualTo(4000.0);
        assertThat(objectUnderTest.totalCost(1501.0)).isEqualTo(4005.0);
        assertThat(objectUnderTest.totalCost(3000.0)).isEqualTo(11500.0);
        assertThat(objectUnderTest.totalCost(3001.0)).isEqualTo(11508.0);
        assertThat(objectUnderTest.totalCost(4000.0)).isEqualTo(19500.0);
    }
}
