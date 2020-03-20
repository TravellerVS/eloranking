package com.vedransemenski.eloranking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BasicCommandFunctionalTests extends ApplicationFunctionalTests {

    private static Stream<List<String>> unknownCommand_throwsException() {
        return Stream.of(Collections.emptyList(),
                Collections.singletonList("unknown_command"),
                Collections.singletonList(" "),
                Collections.singletonList("")
        );
    }

    private static Stream<List<String>> recognisedCommand_doesNotThrowException() {
        return Stream.of(Collections.singletonList("show_ranking"),
                Collections.singletonList("show_list_of_suggested_matches"),
                Arrays.asList("show_report", "Bunny"),
                Arrays.asList("show_detailed_report", "Bunny")
        );
    }

    @ParameterizedTest
    @MethodSource
    void unknownCommand_throwsException(List<String> command) {
        commandExecutesWithException(command);
    }

    @ParameterizedTest
    @MethodSource
    void recognisedCommand_doesNotThrowException(List<String> command) {
        commandExecutesWithoutException(command);
    }

    @Test
    void nonExistingInputFilePaths_throwException() {
        executeCommand(new ArrayList<>(Arrays.asList("nonExistingFile1", "nonExistingFile2", "src/test/resources/nonExistingFile3")),
                Collections.singletonList("show_ranking"));
        assertTrue(readConsoleOutput().contains("Exception"));
    }

}
