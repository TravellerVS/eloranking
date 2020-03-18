package com.vedransemenski.eloranking.cli;

import java.util.List;

public class CommandLineCommand {
    private String command;

    private List<String> additionalParameters;
    private String outputFilePath;

    public CommandLineCommand withCommand(String command) {
        this.command = command;
        return this;
    }

    public String getCommand() {
        return command;
    }

    public String getOutputFilePath() {
        return outputFilePath;
    }

    public List<String> getAdditionalParameters() {
        return additionalParameters;
    }

    public void setAdditionalParameters(List<String> additionalParameters) {
        this.additionalParameters = additionalParameters;
    }

    public CommandLineCommand withOutputFile(String outputFilePath) {
        this.outputFilePath = outputFilePath;
        return this;
    }
}
