package com.vedransemenski.eloranking.pojo;

public class Player {
    private String id;
    private String name;
    private PlayerStats stats;

    public Player(String id, String name) {
        this.id = id;
        this.name = name;
        this.stats = new PlayerStats();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PlayerStats getStats() {
        return stats;
    }
}
