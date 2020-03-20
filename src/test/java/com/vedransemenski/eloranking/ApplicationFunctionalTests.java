package com.vedransemenski.eloranking;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ApplicationFunctionalTests extends ConsoleLineFunctionalTest {

    protected static final String DELIMITER = ",";
    private static final String RESOURCES_MATCHES = "src/test/resources/matches";
    private static final String RESOURCES_NAMES = "src/test/resources/names";
    private static final String RESOURCES_OUTPUT = "src/test/resources/output";

    protected void commandExecutesWithException(List<String> commandArguments) {
        executeCommand(commandArguments);
        assertTrue(readConsoleOutput().contains("Exception"));
    }

    protected void commandExecutesWithoutException(List<String> commandArguments) {
        executeCommand(commandArguments);
        assertFalse(readConsoleOutput().contains("Exception"));
    }

    protected void executeCommand(List<String> commandArguments) {
        List<String> filePathArguments = new ArrayList<>(Arrays.asList(RESOURCES_MATCHES, RESOURCES_NAMES, RESOURCES_OUTPUT));
        executeCommand(filePathArguments, commandArguments);
    }

    protected void executeCommand(List<String> filePathArguments, List<String> commandArguments) {
        String[] arguments = combineListsIntoSingleArray(filePathArguments, commandArguments);
        Application.main(arguments);
    }

    private String[] combineListsIntoSingleArray(List<String> firstList, Collection<String> secondList) {
        firstList.addAll(secondList);
        return firstList.toArray(new String[firstList.size()]);
    }

    protected List<String> getOutputFileContent() throws Exception {
        return Files.readAllLines(Paths.get(RESOURCES_OUTPUT));
    }
}
