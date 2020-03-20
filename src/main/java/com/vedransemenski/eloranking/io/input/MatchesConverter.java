package com.vedransemenski.eloranking.io.input;

import com.vedransemenski.eloranking.pojo.Match;

public class MatchesConverter {
    public static Match convertInputFileLineToDTO(String line) {
        String[] data = line.split(" ");
        return new Match(data[0], data[1]);
    }
}
