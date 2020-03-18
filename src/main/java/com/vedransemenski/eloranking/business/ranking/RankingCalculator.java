package com.vedransemenski.eloranking.business.ranking;

import com.vedransemenski.eloranking.business.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RankingCalculator {


    public Ranking generateRanking() {
        List<Player> ranking = new ArrayList<>();
        ranking.add(new Player("id", "name"));
        return new Ranking(ranking);
    }
}
