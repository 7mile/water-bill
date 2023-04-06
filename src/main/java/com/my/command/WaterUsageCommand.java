package com.my.command;

import com.my.water.WaterUsage;

import java.util.List;

public interface WaterUsageCommand {
    List<WaterUsage> getWaterUsages(int days);
}
