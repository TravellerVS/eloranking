package com.vedransemenski.eloranking.business;

import com.vedransemenski.eloranking.cli.CommandLineArguments;
import com.vedransemenski.eloranking.dataimport.FileImporter;
import org.springframework.stereotype.Service;

@Service
public class Coordinator {

    private FileImporter matchesFileImporter;

    public Coordinator(FileImporter matchesFileImporter) {
        this.matchesFileImporter = matchesFileImporter;
    }

    public void execute(CommandLineArguments arguments) {
        matchesFileImporter.importData(arguments.getMatchesFilePath());

    }
}
