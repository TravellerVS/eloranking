package com.vedransemenski.eloranking.io.output;

import com.vedransemenski.eloranking.business.report.Report;

public interface ReportExporter {
    void export(Report ranking);
}
