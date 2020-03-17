package com.vedransemenski.eloranking.dataimport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileImportUtil {

    private static Logger LOGGER = LoggerFactory.getLogger(FileImportUtil.class);

    public static Stream<String> getStreamOfLines(String filePath) {
        Path path = Paths.get(filePath);
        Stream<String> result = Stream.empty();
        try {
            result = Files.lines(path);
        } catch (IOException e) {
            LOGGER.error(String.format("Input file %s does not exist.", filePath), e);
        }
        return result;
    }
}
