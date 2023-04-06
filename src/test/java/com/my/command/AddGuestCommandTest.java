package com.my.command;

import com.my.water.TankerWater;
import com.my.water.WaterUsage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AddGuestCommandTest {

    @ParameterizedTest
    @CsvSource(value = {"1,1,10", "2,1,20", "3,30,900"})
    public void shouldReturnCorrectWaterUsages(int guestNumber, int days, int literNumber) {
        AddGuestCommand objectUnderTest = new AddGuestCommand(guestNumber);

        assertThat(objectUnderTest.getWaterUsages(days)).asList()
                .usingFieldByFieldElementComparator()
                .containsExactly(new WaterUsage(TankerWater.instance, literNumber));
    }
}
