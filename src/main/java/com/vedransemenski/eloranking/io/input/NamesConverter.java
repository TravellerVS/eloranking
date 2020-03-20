package com.vedransemenski.eloranking.io.input;

import com.vedransemenski.eloranking.pojo.Player;

public class NamesConverter {
    public static Player convertInputFileLineToDTO(String line) {
        String[] data = line.split(" ");
        return new Player(data[0], data[1]);
    }
}
