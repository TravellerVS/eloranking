package com.vedransemenski.eloranking.repository;

import com.vedransemenski.eloranking.business.Match;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MatchesRepository {

    private Set<Match> database = new HashSet<>();

    public void save(Match match) {
        database.add(match);
    }

    public Collection<Match> getAll() {
        return database;
    }
}
