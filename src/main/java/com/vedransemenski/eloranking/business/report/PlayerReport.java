package com.vedransemenski.eloranking.business.report;

import java.util.List;

public class PlayerReport {
    private String playerId;
    private String playerName;
    private double eloRating;
    private List<String> listOfWins;
    private List<String> listOfLoses;

    public PlayerReport(String playerId,
                        String playerName,
                        double eloRating,
                        List<String> listOfWins,
                        List<String> listOfLoses) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.eloRating = eloRating;
        this.listOfWins = listOfWins;
        this.listOfLoses = listOfLoses;
    }

    public String getPlayerName() {
        return playerName;
    }

    public double getEloRating() {
        return eloRating;
    }

    public List<String> getListOfWins() {
        return listOfWins;
    }

    public List<String> getListOfLoses() {
        return listOfLoses;
    }

    public String getPlayerId() {
        return playerId;
    }
}
