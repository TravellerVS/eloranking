package com.vedransemenski.eloranking.io.output;

import com.vedransemenski.eloranking.business.ranking.Ranking;
import com.vedransemenski.eloranking.pojo.Player;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

import static com.vedransemenski.eloranking.io.output.OutputFileWriter.DELIMITER;

@Service
public class RankingExporter {

    private OutputFileWriter fileWriter;

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
