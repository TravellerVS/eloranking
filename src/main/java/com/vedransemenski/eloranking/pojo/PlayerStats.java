package com.vedransemenski.eloranking.pojo;

import java.util.ArrayList;
import java.util.List;

public class PlayerStats {

    private int numberOfWins;
    private int getNumberOfLoses;
    private double eloRating;
    private List<Match> history;

    public PlayerStats() {
        this.history = new ArrayList<>();
        this.eloRating = 1000.0;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    public int getGetNumberOfLoses() {
        return getNumberOfLoses;
    }

    public void setGetNumberOfLoses(int getNumberOfLoses) {
        this.getNumberOfLoses = getNumberOfLoses;
    }

    public double getEloRating() {
        return eloRating;
    }

    public void setEloRating(double eloRating) {
        this.eloRating = eloRating;
    }

    public List<Match> getHistory() {
        return history;
    }

    public void addMatchToHistory(Match match) {
        this.history.add(match);
    }
}
