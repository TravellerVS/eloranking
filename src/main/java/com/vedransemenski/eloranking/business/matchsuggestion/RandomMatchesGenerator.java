package com.vedransemenski.eloranking.business.matchsuggestion;

import com.vedransemenski.eloranking.pojo.Player;
import com.vedransemenski.eloranking.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RandomMatchesGenerator {

    private PlayerRepository repository;

    public RandomMatchesGenerator(PlayerRepository repository) {
        this.repository = repository;
    }

    public List<SuggestedMatch> generateSuggestedMatches() {
        List<SuggestedMatch> result = new ArrayList<>();
        List<Player> players = new ArrayList<>(repository.findAll());
        Collections.shuffle(players);
        for (int i = 0; i < players.size() - 1; i += 2) {
            result.add(new SuggestedMatch(players.get(i).getId(), players.get(i + 1).getId()));
        }
        return result;
    }
}
