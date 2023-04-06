package com.my;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 0) {
            System.err.println("Please set the location for input file");
            exit(1);
        }

        File file = new File(args[0]);

        List<String> inputs = new ArrayList<>();

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            inputs.add(scanner.nextLine());
        }

        CommandManager commandManager = new CommandManager();
        commandManager.executeCommand(inputs);
    }

}

