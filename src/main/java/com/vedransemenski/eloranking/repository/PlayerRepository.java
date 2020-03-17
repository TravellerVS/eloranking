package com.vedransemenski.eloranking.repository;

import com.vedransemenski.eloranking.business.Player;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class PlayerRepository {

    private Set<Player> database = new HashSet<>();

    public void save(Player entity) {
        database.add(entity);
    }
}
