package com.vedransemenski.eloranking.cli;

import com.vedransemenski.eloranking.business.Coordinator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CliRunner implements CommandLineRunner {
    private static Logger LOGGER = LoggerFactory.getLogger(CliRunner.class);
    private Coordinator coordinator;

    public CliRunner(Coordinator coordinator) {
        this.coordinator = coordinator;
    }

    @Override
    public void run(String... args) {
        outputAllArgs(args);
        CommandLineArguments arguments = null;
        try {
            arguments = ArgsParser.parseArgs(args);
        } catch (CliArgumentsException e) {
            LOGGER.error("Could Not accept the given arguments.", e);
        }
        coordinator.execute(arguments);
    }

    private void outputAllArgs(String[] args) {
        for (int i = 0; i < args.length; ++i) {
            LOGGER.info("args[{}]: {}", i, args[i]);
        }
    }
}
