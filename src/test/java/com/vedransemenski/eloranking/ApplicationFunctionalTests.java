package com.vedransemenski.eloranking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApplicationFunctionalTests {

    @BeforeEach
    void setUp() {
    }

    @Test
    void loadingFiles() {
        Application.main(new String[]{"src/test/resources/matches", "src/test/resources/names"});
    }

    @Test
    void showRanking() {
        Application.main(new String[]{"src/test/resources/matches", "src/test/resources/names", "src/test/resources/output", "show_ranking"});
    }
}
