package com.vedransemenski.eloranking.business;

import com.vedransemenski.eloranking.business.ranking.Ranking;
import com.vedransemenski.eloranking.business.ranking.RankingCalculator;
import com.vedransemenski.eloranking.business.report.Report;
import com.vedransemenski.eloranking.business.report.ReportGenerator;
import com.vedransemenski.eloranking.cli.CommandLineCommand;
import com.vedransemenski.eloranking.io.output.RankingExporter;
import com.vedransemenski.eloranking.io.output.SimpleReportExporter;
import org.springframework.stereotype.Service;

@Service
public class CommandExecutor {

    private ReportGenerator reportGenerator;
    private RankingCalculator rankingCalculator;

    private SimpleReportExporter reportExporter;
    private RankingExporter rankingExporter;

    public CommandExecutor(ReportGenerator reportGenerator,
                           RankingCalculator rankingCalculator,
                           SimpleReportExporter reportExporter,
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
                generateReport(playerId);
                break;
            case "show_ranking":
                generateRanking();
                break;
        }
    }

    private void generateRanking() {
        Ranking ranking = rankingCalculator.generateRanking();
        rankingExporter.export(ranking);
    }

    private void generateReport(String playerId) {
        Report report = reportGenerator.generateReport(playerId);
        reportExporter.export(report);
    }

}
