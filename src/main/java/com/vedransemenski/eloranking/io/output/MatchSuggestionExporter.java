package com.vedransemenski.eloranking.io.output;

import com.vedransemenski.eloranking.business.matchsuggestion.SuggestedMatch;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchSuggestionExporter {

    private OutputFileWriter fileWriter;

    public void export(List<SuggestedMatch> suggestedMatches, String outputFilePath) {
        fileWriter = new OutputFileWriter(outputFilePath);
        writeContent(suggestedMatches);
        fileWriter.closeFile();
    }

    private void writeContent(List<SuggestedMatch> matchList) {
        matchList.forEach(suggestedMatch ->
                fileWriter.writeLine(String.format("%s-%s", suggestedMatch.getPlayer1Id(), suggestedMatch.getPlayer2Id())));
    }
}
