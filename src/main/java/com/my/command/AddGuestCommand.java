package com.my.command;

import com.my.water.TankerWater;
import com.my.water.WaterUsage;

import java.util.ArrayList;
import java.util.List;

public class AddGuestCommand implements Command, WaterUsageCommand {
    private int guestNumber;

    private final double PersonalWaterDailyUsageInLiter = 10;

    public AddGuestCommand(int guestNumber) {
        this.guestNumber = guestNumber;
    }

    @Override
    public List<WaterUsage> getWaterUsages(int days) {
        List<WaterUsage> usages = new ArrayList<>(1);
        usages.add(new WaterUsage(TankerWater.instance, guestNumber * days * PersonalWaterDailyUsageInLiter));
        return usages;
    }
}
