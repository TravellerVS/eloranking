package com.vedransemenski.eloranking.dataimport;

import com.vedransemenski.eloranking.repository.MatchesRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class MatchesFileImporter {

    MatchesRepository repository;

    public MatchesFileImporter(MatchesRepository repository) {
        this.repository = repository;
    }

    public void importData(String filePath) {
        Stream<String> inputStream = FileImportUtil.getStreamOfLines(filePath);
        inputStream.map(MatchesConverter::convertInputFileLineToDTO)
                .forEach(match -> repository.save(match));
        inputStream.close();
    }
}
