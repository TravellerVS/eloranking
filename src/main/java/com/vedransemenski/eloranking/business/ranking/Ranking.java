package com.vedransemenski.eloranking.business.ranking;

import com.vedransemenski.eloranking.pojo.Player;

import java.util.List;

public class Ranking {
    List<Player> rankingList;

    public Ranking(List<Player> rankingList) {
        this.rankingList = rankingList;
    }

    public List<Player> getRankingList() {
        return rankingList;
    }
}
