package com.vedransemenski.eloranking.io.output;

import com.vedransemenski.eloranking.business.report.PlayerReport;
import org.springframework.stereotype.Service;

@Service
public class DetailedPlayerReportExporter implements PlayerReportExporter {

    @Override
    public void export(PlayerReport playerReport, String outputFilePath) {

    }
}
