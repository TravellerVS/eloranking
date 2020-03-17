package com.vedransemenski.eloranking.dataimport;

import com.vedransemenski.eloranking.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class NamesFileImporter {

    PlayerRepository repository;

    public NamesFileImporter(PlayerRepository repository) {
        this.repository = repository;
    }

    public void importData(String filePath) {
        Stream<String> inputStream = FileImportUtil.getStreamOfLines(filePath);
        inputStream.map(NamesConverter::convertInputFileLineToDTO)
                .forEach(dto -> repository.save(dto));
        inputStream.close();
    }
}
