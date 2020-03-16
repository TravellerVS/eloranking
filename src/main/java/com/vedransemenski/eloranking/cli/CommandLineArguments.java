package com.vedransemenski.eloranking.cli;

public class CommandLineArguments {
    String playerFilePath;

    String matchesFilePath;

    String command;

    public CommandLineArguments() {
    }

    public CommandLineArguments withPlayerFilePath(String playerFilePath) {
        this.playerFilePath = playerFilePath;
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

    public String getPlayerFilePath() {
        return playerFilePath;
    }

    public String getMatchesFilePath() {
        return matchesFilePath;
    }

    public String getCommand() {
        return command;
    }
}
