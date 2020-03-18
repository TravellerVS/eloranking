package com.vedransemenski.eloranking.business.ranking;

import com.vedransemenski.eloranking.business.Match;
import com.vedransemenski.eloranking.business.PlayerStats;
import com.vedransemenski.eloranking.repository.MatchesRepository;
import com.vedransemenski.eloranking.repository.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerStatsGenerator {

    private MatchesRepository matchesRepository;
    private PlayerRepository playerRepository;

    public PlayerStatsGenerator(MatchesRepository matchesRepository, PlayerRepository playerRepository) {
        this.matchesRepository = matchesRepository;
        this.playerRepository = playerRepository;
    }

    public void generatePlayerStats() {
        matchesRepository.getAll().forEach(this::applyMatchToPlayerStats);
    }

    private void applyMatchToPlayerStats(Match match) {
        PlayerStats winnerStats = playerRepository.get(match.getWinnerId()).getStats();
        PlayerStats loserStats = playerRepository.get(match.getLoserId()).getStats();
        double newWinnerEloRating = EloRatingCalculator.generateNewRating(winnerStats.getEloRating(), loserStats.getEloRating(), true);
        double newLoserEloRating = EloRatingCalculator.generateNewRating(loserStats.getEloRating(), winnerStats.getEloRating(), false);
        updateWinnerStats(match, winnerStats, newWinnerEloRating);
        updateLoserStats(match, loserStats, newLoserEloRating);
    }

    private void updateLoserStats(Match match, PlayerStats stats, double eloRating) {
        stats.setEloRating(eloRating);
        stats.addMatchToHistory(match);
        incrementNumberOfLoses(stats);
    }

    private void updateWinnerStats(Match match, PlayerStats stats, double eloRating) {
        stats.setEloRating(eloRating);
        stats.addMatchToHistory(match);
        incrementNumberOrWins(stats);
    }

    private void incrementNumberOfLoses(PlayerStats loserStats) {
        loserStats.setGetNumberOfLoses(loserStats.getGetNumberOfLoses() + 1);
    }

    private void incrementNumberOrWins(PlayerStats winnerStats) {
        winnerStats.setNumberOfWins(winnerStats.getNumberOfWins() + 1);
    }
}
