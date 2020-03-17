package com.vedransemenski.eloranking.cli;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ArgsParser {
    public static CommandLineArguments parseArgs(String[] args) {
        validateArgs(args);
        return new CommandLineArguments()
                .withMatchesFilePath(args[0])
                .withNamesFilePath(args[1])
                .withCommand(args[2]);
    }

    private static void validateArgs(String[] args) {
        int minArguments = 3;
        if (args == null || args.length < minArguments) {
            throw new CliArgumentsException(String.format("there should be at lease %d arguments provided", minArguments));
        }
        for (String argument : args) {
            if (StringUtils.isEmpty(argument)) {
                throw new CliArgumentsException("None of the arguments provided should be null or empty.");
            }
        }

    }
}
