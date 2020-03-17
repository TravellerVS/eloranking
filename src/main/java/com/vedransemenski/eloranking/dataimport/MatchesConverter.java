package com.vedransemenski.eloranking.dataimport;

import com.vedransemenski.eloranking.business.Match;

public class MatchesConverter {
    public static Match convertInputFileLineToDTO(String line) {
        String[] data = line.split(" ");
        return new Match(data[0], data[1]);
    }
}
