package com.my.command;

import com.my.water.BorewellWater;
import com.my.water.CorporationWater;
import com.my.water.WaterUsage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AllotWaterCommandTest {
    private static final int DAYS = 30;

    @ParameterizedTest
    @CsvSource(value = {"2,1,2,300,600", "2,1,3,225,675", "3,1,2,500,1000"})
    public void shouldReturnCorrectWaterUsages(
            int roomType,
            int corporationPart, int borewellPart,
            int corporationPartLiterNumber, int borewellPartLiterNumber
    ) {
        AllotWaterCommand objectUnderTest = new AllotWaterCommand(roomType, corporationPart, borewellPart);

        assertThat(objectUnderTest.getWaterUsages(DAYS)).asList()
                .usingFieldByFieldElementComparator()
                .containsExactlyInAnyOrder(
                        new WaterUsage(CorporationWater.instance, corporationPartLiterNumber),
                        new WaterUsage(BorewellWater.instance, borewellPartLiterNumber)
                );
    }
}
