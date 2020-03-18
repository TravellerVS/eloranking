package com.vedransemenski.eloranking.cli;

import com.vedransemenski.eloranking.business.CommandExecutor;
import com.vedransemenski.eloranking.io.input.FileImporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CliRunner implements CommandLineRunner {
    private static Logger LOGGER = LoggerFactory.getLogger(CliRunner.class);
    private FileImporter fileImporter;
    private CommandExecutor executor;

    public CliRunner(FileImporter fileImporter, CommandExecutor executor) {
        this.fileImporter = fileImporter;
        this.executor = executor;
    }

    @Override
    public void run(String... args) {
        try {
            executeInitialImport(args);
            handleCommand(args);
        } catch (CliArgumentsException e) {
            LOGGER.error("Could not execute program due to invalid Arguments provided", e);
            outputHelp();
        }
    }

    private void handleCommand(String[] args) {
        CommandLineCommand command = ArgsParser.extractCommand(args);
        executor.execute(command);
    }

    private void executeInitialImport(String[] args) {
        FilePaths filePaths = ArgsParser.extractInputFilePaths(args);
        fileImporter.importFiles(filePaths);
    }

    private void outputHelp() {
        LOGGER.info("-------------------");
        LOGGER.info("-------------------");
    }
}
