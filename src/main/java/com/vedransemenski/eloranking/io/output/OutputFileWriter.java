package com.vedransemenski.eloranking.io.output;

import com.vedransemenski.eloranking.cli.CliRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputFileWriter {

    public static final String DELIMITER = ",";

    private static Logger LOGGER = LoggerFactory.getLogger(CliRunner.class);
    private BufferedWriter writer;
    private String outputFilePath;

    public OutputFileWriter(String outputFilePath) {
        this.outputFilePath = outputFilePath;
        try {
            this.writer = new BufferedWriter(new FileWriter(outputFilePath, false));
        } catch (IOException e) {
            LOGGER.error(String.format("Could not open file %s", outputFilePath), e);
        }
    }

    public void writeLine(String line) {
        try {
            writer.append(line);
            writer.append("\n");
        } catch (IOException e) {
            LOGGER.error(String.format("Could not write to file %s", outputFilePath), e);
        }
    }

    public void closeFile() {
        try {
            writer.close();
        } catch (IOException e) {
            LOGGER.error(String.format("Could not close to file %s", outputFilePath), e);
        }
    }

}
