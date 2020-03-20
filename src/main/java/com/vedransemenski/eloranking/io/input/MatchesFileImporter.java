package com.vedransemenski.eloranking.io.input;

import com.vedransemenski.eloranking.repository.MatchesRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class MatchesFileImporter {

    private MatchesRepository repository;

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
