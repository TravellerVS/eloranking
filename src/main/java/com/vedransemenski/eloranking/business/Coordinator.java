package com.vedransemenski.eloranking.business;

import com.vedransemenski.eloranking.cli.CommandLineArguments;
import com.vedransemenski.eloranking.dataimport.MatchesFileImporter;
import com.vedransemenski.eloranking.dataimport.NamesFileImporter;
import org.springframework.stereotype.Service;

@Service
public class Coordinator {

    private MatchesFileImporter matchesFileImporter;
    private NamesFileImporter namesFileImporter;

    public Coordinator(MatchesFileImporter matchesFileImporter, NamesFileImporter namesFileImporter) {
        this.matchesFileImporter = matchesFileImporter;
        this.namesFileImporter = namesFileImporter;
    }

    public void execute(CommandLineArguments arguments) {
        namesFileImporter.importData(arguments.getNamesFilePath());
        matchesFileImporter.importData(arguments.getMatchesFilePath());

    }
}
