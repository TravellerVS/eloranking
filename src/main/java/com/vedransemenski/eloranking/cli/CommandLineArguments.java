package com.vedransemenski.eloranking.cli;

public class CommandLineArguments {
    String namesFilePath;

    String matchesFilePath;

    String command;

    public CommandLineArguments() {
    }

    public CommandLineArguments withNamesFilePath(String playerFilePath) {
        this.namesFilePath = playerFilePath;
        return this;
    }

    public CommandLineArguments withMatchesFilePath(String matchesFilePath) {
        this.matchesFilePath = matchesFilePath;
        return this;
    }

    public CommandLineArguments withCommand(String command) {
        this.command = command;
        return this;
    }

    public String getNamesFilePath() {
        return namesFilePath;
    }

    public String getMatchesFilePath() {
        return matchesFilePath;
    }

    public String getCommand() {
        return command;
    }
}
