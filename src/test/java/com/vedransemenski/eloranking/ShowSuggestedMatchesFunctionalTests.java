package com.vedransemenski.eloranking;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ShowSuggestedMatchesFunctionalTests extends ApplicationFunctionalTests {

    @Test
    void showListOfSuggestedMatches_createsValidContent() throws Exception {
        executeCommand(Collections.singletonList("show_list_of_suggested_matches"));
        List<String> outputFileContent = getOutputFileContent();
        assertEquals(20, outputFileContent.size());
        validateEveryPlayerPlaysOnlyOnce(outputFileContent);
    }

    private void validateEveryPlayerPlaysOnlyOnce(List<String> outputFileContent) {
        Set<String> alreadyMatched = new HashSet<>();
        outputFileContent.forEach(line -> {
            String[] playerIds = line.split("-");
            assertFalse(alreadyMatched.contains(playerIds[0]));
            alreadyMatched.add(playerIds[0]);
            assertFalse(alreadyMatched.contains(playerIds[1]));
            alreadyMatched.add(playerIds[1]);
        });
    }

}
