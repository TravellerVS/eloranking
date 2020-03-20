package com.vedransemenski.eloranking;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShowRankingFunctionalTests extends ApplicationFunctionalTests {

    @Test
    void showRanking_creates_validContent() throws Exception {
        executeCommand(Collections.singletonList("show_ranking"));
        List<String> outputFileContent = getOutputFileContent();

        validateHeader(outputFileContent);
        assertEquals(41, outputFileContent.size());
        validateMainContent(outputFileContent);
    }

    private void validateMainContent(List<String> outputFileContent) {
        for (int i = 1; i < outputFileContent.size(); i++) {
            String currentLine = outputFileContent.get(i);
            linesGoFromTopToBottomRank(i, currentLine);
            if (i > 1) {
                String previousLine = outputFileContent.get(i - 1);
                previousLinesRatingIsBiggerOrEqualToCurrentLine(currentLine, previousLine);
            }
        }
    }

    private void linesGoFromTopToBottomRank(int i, String currentLine) {
        assertTrue(currentLine.startsWith(Integer.toString(i)));
    }

    private void previousLinesRatingIsBiggerOrEqualToCurrentLine(String currentLine, String previousLine) {
        double previousRating = extractRanking(previousLine);
        double currentRating = extractRanking(currentLine);
        assertTrue(previousRating >= currentRating);
    }

    private double extractRanking(String currentLine) {
        return Double.parseDouble(currentLine.split(DELIMITER)[3]);
    }

    private void validateHeader(List<String> outputFileContent) {
        assertEquals("rank,name,id,eloRating", outputFileContent.get(0));
    }
}
