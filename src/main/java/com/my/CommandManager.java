package com.my;

import com.my.command.*;
import com.my.exception.IllegalCommandException;
import com.my.water.WaterUsage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommandManager {
    private static final int BILLING_PERIOD_IN_DAYS = 30;

    public void executeCommand(List<String> inputs) {
        List<Command> commands = verifyAndGetCommands(
                inputs.stream()
                        .filter(input -> input != null && input.trim().length() > 0)
                        .collect(Collectors.toList())
        );

        WaterBillManagerInterface billManager = new WaterBillManager();
        commands.forEach(
                command -> {
                    if (command instanceof WaterUsageCommand) {
                        List<WaterUsage> usages = ((WaterUsageCommand) command).getWaterUsages(BILLING_PERIOD_IN_DAYS);
                        billManager.add(usages);
                    }
                }
        );

        System.out.println(billManager.getTotalWaterUsageInLiter() + " - " + billManager.getTotalWaterCost());
    }

    private List<Command> verifyAndGetCommands(List<String> inputs) {
        List<Command> commands = new ArrayList<>();
        int guestNumber = 0;

        for (int i = 0; i < inputs.size(); i++) {
            String input = inputs.get(i);
            String[] inputParts = input.trim().split(" ");
            if (i == 0 && !"ALLOT_WATER".equals(inputParts[0])) {
                throw new IllegalCommandException("ALLOT_WATER should be the first command.");
            }

            switch (inputParts[0]) {
                case "ALLOT_WATER":
                    if (i != 0) {
                        throw new IllegalCommandException("ALLOT_WATER should appear only once.");
                    }
                    commands.add(getAllotWaterCommand(inputParts));
                    break;

                case "ADD_GUESTS":
                    if (inputParts.length != 2) {
                        throw new IllegalCommandException("ADD_GUESTS should include 1 param.");
                    }
                    try {
                        guestNumber += Integer.parseInt(inputParts[1]);
                    } catch (Exception exception) {
                        throw new IllegalCommandException("ADD_GUESTS has invalid guest number.");
                    }
                    break;

                case "BILL":
                    if (i != inputs.size() - 1) {
                        throw new IllegalCommandException("BILL should be the last command.");
                    }
                    commands.add(new AddGuestCommand(guestNumber));
                    commands.add(new BillCommand());
                    break;

                default:
                    throw new IllegalCommandException("Command not supported.");
            }
        }

        return commands;
    }

    private Command getAllotWaterCommand(String[] inputParts) {
        if (inputParts.length != 3) {
            throw new IllegalCommandException("ALLOT_WATER should include 2 params.");
        }
        int corporationPart;
        int borewellPart;
        try {
            String[] waterRatio = inputParts[2].trim().split(":");
            corporationPart = Integer.parseInt(waterRatio[0]);
            borewellPart = Integer.parseInt(waterRatio[1]);
        } catch (Exception e) {
            throw new IllegalCommandException("ALLOT_WATER water ratio param is invalid.");
        }

        if (corporationPart <= 0 || borewellPart <= 0) {
            throw new IllegalCommandException("ALLOT_WATER water ratio param should be positive numbers.");
        }

        return new AllotWaterCommand(Integer.parseInt(inputParts[1]), corporationPart, borewellPart);
    }
}
