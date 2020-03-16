package com.vedransemenski.eloranking.cli;

import com.vedransemenski.eloranking.Application;
import com.vedransemenski.eloranking.business.Coordinator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CliRunner implements CommandLineRunner {
    private static Logger LOGGER = LoggerFactory
            .getLogger(Application.class);
    private ArgsParser argsParser;
    private Coordinator coordinator;

    public CliRunner(ArgsParser argsParser, Coordinator coordinator) {
        this.argsParser = argsParser;
        this.coordinator = coordinator;
    }

    @Override
    public void run(String... args) {
        LOGGER.info("EXECUTING : command line runner");
        outputAllArgs(args);
        CommandLineArguments arguments = ArgsParser.parseArgs(args);
        coordinator.execute(arguments);
    }

    private void outputAllArgs(String[] args) {
        for (int i = 0; i < args.length; ++i) {
            LOGGER.info("args[{}]: {}", i, args[i]);
        }
    }
}
