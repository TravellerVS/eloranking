package com.vedransemenski.eloranking.business;

import com.vedransemenski.eloranking.business.ranking.Ranking;
import com.vedransemenski.eloranking.business.ranking.RankingCalculator;
import com.vedransemenski.eloranking.business.report.PlayerReport;
import com.vedransemenski.eloranking.business.report.ReportGenerator;
import com.vedransemenski.eloranking.cli.CommandLineCommand;
import com.vedransemenski.eloranking.io.output.RankingExporter;
import com.vedransemenski.eloranking.io.output.SimplePlayerReportExporter;
import org.springframework.stereotype.Service;

@Service
public class CommandExecutor {

    private ReportGenerator reportGenerator;
    private RankingCalculator rankingCalculator;
    private SimplePlayerReportExporter reportExporter;
    private RankingExporter rankingExporter;

    public CommandExecutor(ReportGenerator reportGenerator,
                           RankingCalculator rankingCalculator,
                           SimplePlayerReportExporter reportExporter,
                           RankingExporter rankingExporter) {
        this.reportGenerator = reportGenerator;
        this.rankingCalculator = rankingCalculator;
        this.reportExporter = reportExporter;
        this.rankingExporter = rankingExporter;
    }

    public void execute(CommandLineCommand command) {
        switch (command.getCommand()) {
            case "show_report":
                String playerId = command.getAdditionalParameters().get(0);
                generateReport(playerId, command.getOutputFilePath());
                break;
            case "show_ranking":
                generateRanking(command.getOutputFilePath());
                break;
        }
    }

    private void generateRanking(String outputFilePath) {
        Ranking ranking = rankingCalculator.generateRanking();
        rankingExporter.export(ranking, outputFilePath);
    }

    private void generateReport(String playerId, String outputFilePath) {
        PlayerReport playerReport = reportGenerator.generateReport(playerId);
        reportExporter.export(playerReport, outputFilePath);
    }

}
