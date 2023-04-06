package com.my.command;

import com.my.water.BorewellWater;
import com.my.water.CorporationWater;
import com.my.water.WaterUsage;

import java.util.ArrayList;
import java.util.List;

public class AllotWaterCommand implements Command, WaterUsageCommand {
    private int roomType;
    private int corporationPart = 0;
    private int borewellPart = 0;
    private final double PersonalWaterDailyUsageInLiter = 10;

    public AllotWaterCommand(int roomType,  int corporationPart, int borewellPart) {
        this.roomType = roomType;
        this.corporationPart = corporationPart;
        this.borewellPart=borewellPart;
    }

    @Override
    public List<WaterUsage> getWaterUsages(int days) {

        int residentNumber = 0;
        switch (roomType) {
            case 2:
                residentNumber = 3;
                break;
            case 3:
                residentNumber = 5;
                break;
            default:
                throw new RuntimeException("Not supported room type");
        }
        List<WaterUsage> waterUsages = new ArrayList<>(2);
        waterUsages.add(new WaterUsage(CorporationWater.instance, corporationWaterUsageInLiter(residentNumber, days)));
        waterUsages.add(new WaterUsage(BorewellWater.instance, borewellWaterUsageInLiter(residentNumber, days)));

        return waterUsages;
    }

    private double corporationWaterUsageInLiter(int residentNumber, int days) {
        return residentNumber * days * PersonalWaterDailyUsageInLiter * corporationPart / (corporationPart + borewellPart);
    }

    private double borewellWaterUsageInLiter(int residentNumber, int days) {
        return residentNumber * days * PersonalWaterDailyUsageInLiter * borewellPart / (corporationPart + borewellPart);
    }
}
