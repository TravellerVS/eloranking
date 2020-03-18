package com.vedransemenski.eloranking.cli;

public class FilePaths {
    String namesFilePath;

    String matchesFilePath;

    public FilePaths() {
    }

    public FilePaths withNamesFilePath(String playerFilePath) {
        this.namesFilePath = playerFilePath;
        return this;
    }

    public FilePaths withMatchesFilePath(String matchesFilePath) {
        this.matchesFilePath = matchesFilePath;
        return this;
    }

    public String getNamesFilePath() {
        return namesFilePath;
    }

    public String getMatchesFilePath() {
        return matchesFilePath;
    }

}
