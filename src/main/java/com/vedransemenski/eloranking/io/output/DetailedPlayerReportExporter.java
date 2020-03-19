package com.vedransemenski.eloranking.io.output;

import com.vedransemenski.eloranking.business.report.PlayerReport;
import org.springframework.stereotype.Service;

@Service
public class DetailedPlayerReportExporter implements PlayerReportExporter {

    private OutputFileWriter fileWriter;

    @Override
    public void export(PlayerReport report, String outputFilePath) {
        fileWriter = new OutputFileWriter(outputFilePath);
        writeHeader(report);
        writeContent(report);
        fileWriter.closeFile();
    }

    private void writeHeader(PlayerReport report) {
        fileWriter.writeLine(String.format("This is a Performance Report for Player %s", report.getPlayerName()));
    }

    private void writeContent(PlayerReport report) {
        writeStatsSummary(report);
    }

    private void writeStatsSummary(PlayerReport report) {
        writeReportSummary(report);
        writeMatchHistory(report);

    }

    private void writeMatchHistory(PlayerReport report) {
        String listOfWins = report.getListOfWins().toString();
        fileWriter.writeLine(String.format("List of players against which player %s WON: %s", report.getPlayerName(), listOfWins));
        String listOfLoses = report.getListOfLoses().toString();
        fileWriter.writeLine(String.format("List of players against which player %s LOST: %s", report.getPlayerName(), listOfLoses));
    }

    private void writeReportSummary(PlayerReport report) {
        String rating = Double.toString(report.getEloRating());
        fileWriter.writeLine(String.format("Name: %s", report.getPlayerName()));
        fileWriter.writeLine(String.format("Id: %s", report.getPlayerId()));
        fileWriter.writeLine(String.format("Elo Rating: %s", rating));
        fileWriter.writeLine(String.format("Total number of Wins: %d", report.getListOfWins().size()));
        fileWriter.writeLine(String.format("Total number of Loses: %d", report.getListOfLoses().size()));
    }
}
