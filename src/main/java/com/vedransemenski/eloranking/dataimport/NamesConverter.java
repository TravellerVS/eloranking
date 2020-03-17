package com.vedransemenski.eloranking.dataimport;

import com.vedransemenski.eloranking.business.Player;

public class NamesConverter {
    public static Player convertInputFileLineToDTO(String line) {
        String[] data = line.split(" ");
        return new Player(data[0], data[1]);
    }
}
