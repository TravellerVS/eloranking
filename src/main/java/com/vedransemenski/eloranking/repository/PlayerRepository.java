package com.vedransemenski.eloranking.repository;

import com.vedransemenski.eloranking.business.Player;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PlayerRepository {

    private Map<String, Player> database = new HashMap<>();

    public void save(Player entity) {
        database.put(entity.getId(), entity);
    }

    public void get(String playerId) {
        database.get(database.get(playerId));
    }
}
