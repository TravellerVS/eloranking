package com.vedransemenski.eloranking;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ApplicationFunctionalTests extends ConsoleLineFunctionalTest {

    private static final String RESOURCES_MATCHES = "src/test/resources/matches";
    private static final String RESOURCES_NAMES = "src/test/resources/names";
    private static final String RESOURCES_OUTPUT = "src/test/resources/output";

    @Test
    void loadingFiles() {
        Application.main(new String[]{RESOURCES_MATCHES, RESOURCES_NAMES});
        assertTrue(readConsoleOutput().contains("Exception"));
    }

    @Test
    void showRanking() {
        commandExecutesWithoutException(Collections.singletonList("show_ranking"));
    }

    @Test
    void showListOfSuggestedMatches() {
        commandExecutesWithoutException(Collections.singletonList("show_list_of_suggested_matches"));
    }

    @Test
    void showReport() {
        commandExecutesWithoutException(Arrays.asList("show_report", "Bunny"));
    }

    @Test
    void showDetailedReport() {
        commandExecutesWithoutException(Arrays.asList("show_detailed_report", "Bunny"));
    }

    private void commandExecutesWithoutException(List<String> commandArguments) {
        List<String> filePathArguments = new ArrayList<>(Arrays.asList(RESOURCES_MATCHES, RESOURCES_NAMES, RESOURCES_OUTPUT));
        String[] arguments = combineListsIntoSingleArray(filePathArguments, commandArguments);
        Application.main(arguments);
        assertFalse(readConsoleOutput().contains("Exception"));
    }

    private String[] combineListsIntoSingleArray(List<String> firstList, Collection<String> secondList) {
        firstList.addAll(secondList);
        return firstList.toArray(new String[firstList.size()]);
    }
}
