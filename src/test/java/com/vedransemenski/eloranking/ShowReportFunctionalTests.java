package com.vedransemenski.eloranking;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShowReportFunctionalTests extends ApplicationFunctionalTests {

    @Test
    void showSimpleReport_withNoPlayerName_executesWithException() {
        commandExecutesWithException(Collections.singletonList("show_report"));
    }

    @Test
    void showDetailedReport_withNoPlayerName_executesWithException() {
        commandExecutesWithException(Collections.singletonList("show_detailed_report"));
    }

    @Test
    void showSimpleReport_createsValidContent() throws Exception {
        executeCommand(Arrays.asList("show_report", "Bunny"));
        List<String> outputFileContent = getOutputFileContent();
        assertEquals("name,id,eloRating,numberOfWins,numberOfLoses", outputFileContent.get(0));
        assertTrue(outputFileContent.get(1).startsWith("Bunny,4"));
        assertTrue(outputFileContent.get(1).endsWith("2,6"));
        assertEquals(2, outputFileContent.size());
    }

    @Test
    void showDetailedReport_createsValidContent() throws Exception {
        executeCommand(Arrays.asList("show_detailed_report", "Bunny"));
        List<String> outputFileContent = getOutputFileContent();
        assertEquals("This is a Performance Report for Player Bunny", outputFileContent.get(0));
        assertEquals("Name: Bunny", outputFileContent.get(1));
        assertEquals("Id: 4", outputFileContent.get(2));
        assertTrue(outputFileContent.get(3).startsWith("Elo Rating: "));
        assertEquals("Total number of Wins: 2", outputFileContent.get(4));
        assertEquals("Total number of Loses: 6", outputFileContent.get(5));
        assertTrue(outputFileContent.get(6).startsWith("List of players against which player Bunny WON: "));
        assertTrue(outputFileContent.get(7).startsWith("List of players against which player Bunny LOST: "));
        assertEquals(8, outputFileContent.size());
    }
}
