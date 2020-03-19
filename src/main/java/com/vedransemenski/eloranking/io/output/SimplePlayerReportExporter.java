package com.vedransemenski.eloranking.io.output;

import com.vedransemenski.eloranking.business.report.PlayerReport;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

import static com.vedransemenski.eloranking.io.output.OutputFileWriter.DELIMITER;

@Service
public class SimplePlayerReportExporter implements PlayerReportExporter {

    private OutputFileWriter fileWriter;

    @Override
    public void export(PlayerReport report, String outputFilePath) {
        fileWriter = new OutputFileWriter(outputFilePath);
        writeHeader();
        writeContent(report);
        fileWriter.closeFile();
    }

    private void writeHeader() {
        fileWriter.writeLine("name,id,eloRating,numberOfWins,numberOfLoses");
    }

    private void writeContent(PlayerReport report) {
        String rating = Double.toString(report.getEloRating());
        String line = MessageFormat.format("{1}{0}{2}{0}{3}{0}{4}{0}{5}",
                DELIMITER, report.getPlayerName(), report.getPlayerId(), rating,
                report.getListOfWins().size(), report.getListOfLoses().size());
        fileWriter.writeLine(line);
    }
}
