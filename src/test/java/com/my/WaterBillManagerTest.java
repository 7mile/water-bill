package com.my;

import com.my.water.CorporationWater;
import com.my.water.TankerWater;
import com.my.water.WaterUsage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WaterBillManagerTest {
    WaterBillManager objectUnderTest = new WaterBillManager();

    @Test
    public void shouldReturnCorrectTotalWaterUsageInLiterAndWaterCost() {
        List<WaterUsage> waterUsages = new ArrayList<>();
        waterUsages.add(new WaterUsage(TankerWater.instance, 300));
        waterUsages.add(new WaterUsage(CorporationWater.instance, 300));

        objectUnderTest.add(waterUsages);

        assertThat(objectUnderTest.getTotalWaterUsageInLiter()).isEqualTo(600);
        assertThat(objectUnderTest.getTotalWaterCost()).isEqualTo(900);
    }
}
