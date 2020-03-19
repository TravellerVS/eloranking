package com.vedransemenski.eloranking.io.output;

import com.vedransemenski.eloranking.business.report.PlayerReport;

public interface PlayerReportExporter {
    
    void export(PlayerReport playerReport, String outputFilePath);
}
