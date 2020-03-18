package com.vedransemenski.eloranking.business;

public class Match {
    private String winnerId;
    private String loserId;

    public Match(String winnerId, String loserId) {
        this.winnerId = winnerId;
        this.loserId = loserId;
    }

    public String getWinnerId() {
        return winnerId;
    }

    public String getLoserId() {
        return loserId;
    }
}
