package com.vedransemenski.eloranking.io.output;

import com.vedransemenski.eloranking.business.Player;
import com.vedransemenski.eloranking.business.ranking.Ranking;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class RankingExporter {

    public static final String DELIMITER = ",";
    OutputFileWriter fileWriter;

    public void export(Ranking ranking, String outputFilePath) {
        fileWriter = new OutputFileWriter(outputFilePath);
        writeHeader();
        writeContent(ranking);
        fileWriter.closeFile();
    }

    private void writeContent(Ranking ranking) {
        int rank = 0;
        for (Player player : ranking.getRankingList()) {
            rank++;
            fileWriter.writeLine(generateNewLine(rank, player));
        }
    }

    private void writeHeader() {
        fileWriter.writeLine("rank,name,id,eloRating");
    }

    private String generateNewLine(int rank, Player player) {
        String rating = Double.toString(player.getStats().getEloRating());
        return MessageFormat.format("{1}{0}{2}{0}{3}{0}{4}", DELIMITER, rank, player.getName(), player.getId(), rating);
    }
}
