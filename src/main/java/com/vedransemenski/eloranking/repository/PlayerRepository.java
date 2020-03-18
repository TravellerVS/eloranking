package com.vedransemenski.eloranking.repository;

import com.vedransemenski.eloranking.business.Player;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PlayerRepository {

    private Map<String, Player> database = new HashMap<>();

    public void save(Player entity) {
        database.put(entity.getId(), entity);
    }

    public Player get(String playerId) {
        return database.get(playerId);
    }

    public Collection<Player> getAll() {
        return database.values();
    }
}
