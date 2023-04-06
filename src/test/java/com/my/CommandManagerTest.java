package com.my;

import com.my.exception.IllegalCommandException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.*;


public class CommandManagerTest {
    @ParameterizedTest
    @CsvSource(value = {
            "Invalid",
            "BILL",
            "ADD_GUESTS 2",
            "ALLOT_WATER 2",
            "ALLOT_WATER 2 1:",
            "ALLOT_WATER 2 a:b",
            "ALLOT_WATER 2 1:-1",
            "ALLOT_WATER 2 1:0"
    })
    public void shouldThrowException(String input) {
        CommandManager manager = new CommandManager();
        List<String> inputs = new ArrayList<>(1);
        inputs.add(input);

        Throwable thrown = catchThrowable(() ->
                manager.executeCommand(inputs)
        );

        assertThat(thrown).isInstanceOf(IllegalCommandException.class);
    }

    @Test
    public void shouldExecuteCommandsWithoutThrowExceptions() {
        CommandManager manager = new CommandManager();
        List<String> inputs = new ArrayList<>(3);
        inputs.add("ALLOT_WATER 2 1:2");
        inputs.add("ADD_GUESTS 2");
        inputs.add("BILL");

        manager.executeCommand(inputs);
    }
}
