package com.vedransemenski.eloranking.business.report;

import com.vedransemenski.eloranking.business.Player;
import com.vedransemenski.eloranking.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportGenerator {
    private PlayerRepository repository;

    public ReportGenerator(PlayerRepository repository) {
        this.repository = repository;
    }

    public PlayerReport generateReport(String playerName) {
        Player player = repository.findByName(playerName);
        return convertToReport(player);
    }

    private PlayerReport convertToReport(Player player) {
        List<String> listOfWins = new ArrayList<>();
        List<String> listOfLoses = new ArrayList<>();
        player.getStats().getHistory().forEach(match -> {
            if (match.getWinnerId().equals(player.getId())) {
                listOfWins.add(getPlayerNameFromId(match.getLoserId()));
            } else {
                listOfLoses.add(getPlayerNameFromId(match.getWinnerId()));
            }
        });
        return new PlayerReport(player.getId(), player.getName(), player.getStats().getEloRating(), listOfWins, listOfLoses);
    }

    private String getPlayerNameFromId(String loserId) {
        return repository.find(loserId).getName();
    }
}
