package com.vedransemenski.eloranking.business.ranking;

import com.vedransemenski.eloranking.pojo.Player;
import com.vedransemenski.eloranking.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RankingCalculator {
    private PlayerRepository playerRepository;

    public RankingCalculator(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Ranking generateRanking() {
        List<Player> listOfPlayersSortedByRank = playerRepository.findAll()
                .stream()
                .sorted(this::isRankedHigher)
                .collect(Collectors.toList());
        return new Ranking(listOfPlayersSortedByRank);
    }

    private int isRankedHigher(Player p1, Player p2) {
        return (p1.getStats().getEloRating() > p2.getStats().getEloRating()) ? -1 : 1;
    }
}
