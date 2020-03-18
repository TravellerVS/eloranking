package com.vedransemenski.eloranking.io.input;

import com.vedransemenski.eloranking.cli.FilePaths;
import org.springframework.stereotype.Service;

@Service
public class FileImporter {

    private MatchesFileImporter matchesFileImporter;
    private NamesFileImporter namesFileImporter;

    public FileImporter(MatchesFileImporter matchesFileImporter, NamesFileImporter namesFileImporter) {
        this.matchesFileImporter = matchesFileImporter;
        this.namesFileImporter = namesFileImporter;
    }

    public void importFiles(FilePaths arguments) {
        namesFileImporter.importData(arguments.getNamesFilePath());
        matchesFileImporter.importData(arguments.getMatchesFilePath());

    }
}
