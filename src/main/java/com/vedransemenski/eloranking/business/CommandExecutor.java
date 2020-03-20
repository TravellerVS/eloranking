package com.vedransemenski.eloranking.business;

import com.vedransemenski.eloranking.business.matchsuggestion.RandomMatchesGenerator;
import com.vedransemenski.eloranking.business.matchsuggestion.SuggestedMatch;
import com.vedransemenski.eloranking.business.ranking.Ranking;
import com.vedransemenski.eloranking.business.ranking.RankingCalculator;
import com.vedransemenski.eloranking.business.report.PlayerReport;
import com.vedransemenski.eloranking.business.report.ReportGenerator;
import com.vedransemenski.eloranking.cli.CliArgumentsException;
import com.vedransemenski.eloranking.cli.CommandLineCommand;
import com.vedransemenski.eloranking.io.output.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandExecutor {

    private static Logger LOGGER = LoggerFactory.getLogger(CommandExecutor.class);

    private ReportGenerator reportGenerator;
    private RankingCalculator rankingCalculator;
    private SimplePlayerReportExporter simplePlayerReportExporter;
    private DetailedPlayerReportExporter detailedPlayerReportExporter;
    private RankingExporter rankingExporter;
    private RandomMatchesGenerator randomMatchesGenerator;
    private MatchSuggestionExporter matchSuggestionExporter;

    public CommandExecutor(ReportGenerator reportGenerator,
                           RankingCalculator rankingCalculator,
                           SimplePlayerReportExporter simplePlayerReportExporter,
                           DetailedPlayerReportExporter detailedPlayerReportExporter,
                           RankingExporter rankingExporter,
                           RandomMatchesGenerator randomMatchesGenerator,
                           MatchSuggestionExporter matchSuggestionExporter) {
        this.reportGenerator = reportGenerator;
        this.rankingCalculator = rankingCalculator;
        this.simplePlayerReportExporter = simplePlayerReportExporter;
        this.detailedPlayerReportExporter = detailedPlayerReportExporter;
        this.rankingExporter = rankingExporter;
        this.randomMatchesGenerator = randomMatchesGenerator;
        this.matchSuggestionExporter = matchSuggestionExporter;
    }

    public void execute(CommandLineCommand command) {
        String outputFilePath = command.getOutputFilePath();
        LOGGER.info(String.format("Running command: %s", command.getCommand()));
        switch (command.getCommand()) {
            case "show_report":
                generateReport(getPlayerName(command), outputFilePath, simplePlayerReportExporter);
                break;
            case "show_detailed_report":
                generateReport(getPlayerName(command), outputFilePath, detailedPlayerReportExporter);
                break;
            case "show_ranking":
                generateRanking(outputFilePath);
                break;
            case "show_list_of_suggested_matches":
                generateListOfSuggestedMatches(outputFilePath);
                break;
            default:
                throw new CliArgumentsException(String.format("Given command %s was not recognised.", command.getCommand()));
        }
        LOGGER.info(String.format("Finished and exported output to: %s", outputFilePath));
    }

    private String getPlayerName(CommandLineCommand command) {
        try {
            return command.getAdditionalParameters().get(0);
        } catch (IllegalStateException | IndexOutOfBoundsException e) {
            throw new CliArgumentsException(String.format("Given command %s should contain player name.", command.getCommand()));
        }
    }

    private void generateListOfSuggestedMatches(String outputFilePath) {
        List<SuggestedMatch> suggestedMatches = randomMatchesGenerator.generateSuggestedMatches();
        matchSuggestionExporter.export(suggestedMatches, outputFilePath);
    }

    private void generateRanking(String outputFilePath) {
        Ranking ranking = rankingCalculator.generateRanking();
        rankingExporter.export(ranking, outputFilePath);
    }

    private void generateReport(String playerName, String outputFilePath, PlayerReportExporter reportExporter) {
        PlayerReport playerReport = reportGenerator.generateReport(playerName);
        reportExporter.export(playerReport, outputFilePath);
    }

}
