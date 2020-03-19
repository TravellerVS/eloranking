package com.vedransemenski.eloranking.business.matchsuggestion;

public class SuggestedMatch {
    private String player1Id;
    private String player2Id;

    public SuggestedMatch(String player1Id, String player2Id) {
        this.player1Id = player1Id;
        this.player2Id = player2Id;
    }

    public String getPlayer1Id() {
        return player1Id;
    }

    public String getPlayer2Id() {
        return player2Id;
    }
}
