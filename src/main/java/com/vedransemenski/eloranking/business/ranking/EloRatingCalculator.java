package com.vedransemenski.eloranking.business.ranking;

public class EloRatingCalculator {

    private static final int K_FACTOR = 32;

    /**
     * Ea - Expected Score for A
     * Ra - Current Rating for A
     * Rb - Current Rating for B
     * Ra' - new Rating for A
     * K factor used = 32
     * score = 1 for winning, 0 for losing
     * Formulas used
     * Ea = 1 / ( 1 + 10^((Rb-Ra)/400) )
     * Ra' = Ra + 32*(score - Ea)
     */
    public static double generateNewRating(double currentRating, double opponentRating, boolean didWin) {
        double Ra = currentRating;
        double Rb = opponentRating;
        double score = (didWin) ? 1.0 : 0.0;
        double Ea = 1.0 / (1.0 + Math.pow(10.0, (Rb - Ra) / 400.0));
        return Ra + K_FACTOR * (score - Ea);
    }
}
