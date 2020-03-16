package com.vedransemenski.eloranking.cli;

import org.springframework.stereotype.Service;

@Service
public class ArgsParser {
    public static CommandLineArguments parseArgs(String[] args) {
        return new CommandLineArguments()
                .withPlayerFilePath(args[0])
                .withMatchesFilePath(args[1])
                .withCommand(args[2]);
    }
}
