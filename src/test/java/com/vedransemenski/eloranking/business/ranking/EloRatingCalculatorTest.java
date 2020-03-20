package com.vedransemenski.eloranking.business.ranking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class EloRatingCalculatorTest {

    private static final double INITIAL_RATING = 1000.0;

    private static final double OPPONENT_RATING = 1000.0;

    @Test
    void generateNewRating_afterWin_shouldBeHigher() {
        assertTrue(INITIAL_RATING < EloRatingCalculator.generateNewRating(INITIAL_RATING, OPPONENT_RATING, true));
    }

    @Test
    void generateNewRating_afterLose_shouldBeLower() {
        assertTrue(INITIAL_RATING > EloRatingCalculator.generateNewRating(INITIAL_RATING, OPPONENT_RATING, false));
    }

    @Test
    void generateNewRating_afterWinAndThenLoseAgainstTheSameRatedPlayer_shouldBeLower() {
        double newRating = EloRatingCalculator.generateNewRating(INITIAL_RATING, OPPONENT_RATING, true);
        assertTrue(INITIAL_RATING > EloRatingCalculator.generateNewRating(newRating, OPPONENT_RATING, false));
    }

    @Test
    void generateNewRating_afterLoseAndThenWinAgainstTheSameRatedPlayer_shouldBeHigher() {
        double newRating = EloRatingCalculator.generateNewRating(INITIAL_RATING, OPPONENT_RATING, false);
        assertTrue(INITIAL_RATING < EloRatingCalculator.generateNewRating(newRating, OPPONENT_RATING, true));
    }

    @Test
    void generateNewRating_losingToALowerRankedPlayerIsWorstThanLosingToAHigherRankedOne() {
        double afterLosingToGoodPlayer = EloRatingCalculator.generateNewRating(INITIAL_RATING, OPPONENT_RATING * 2, false);
        double afterLosingToBadPlayer = EloRatingCalculator.generateNewRating(INITIAL_RATING, OPPONENT_RATING / 2, false);

        assertTrue(afterLosingToBadPlayer < afterLosingToGoodPlayer);
    }
}