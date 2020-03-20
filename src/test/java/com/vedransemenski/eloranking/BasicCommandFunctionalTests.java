package com.vedransemenski.eloranking;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

class BasicCommandFunctionalTests extends ApplicationFunctionalTests {

    @Test
    void noCommand_throwsException() {
        commandExecutesWithException(Collections.emptyList());
    }

    @Test
    void unknownCommand_throwsException() {
        commandExecutesWithException(Collections.singletonList("unknown_command"));
    }

    @Test
    void showRanking_doesNotThrowException() {
        commandExecutesWithoutException(Collections.singletonList("show_ranking"));
    }

    @Test
    void showListOfSuggestedMatches_doesNotThrowException() {
        commandExecutesWithoutException(Collections.singletonList("show_list_of_suggested_matches"));
    }

    @Test
    void showReport_doesNotThrowException() {
        commandExecutesWithoutException(Arrays.asList("show_report", "Bunny"));
    }

    @Test
    void showDetailedReport_doesNotThrowException() {
        commandExecutesWithoutException(Arrays.asList("show_detailed_report", "Bunny"));
    }
}
