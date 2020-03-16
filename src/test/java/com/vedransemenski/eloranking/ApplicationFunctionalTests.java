package com.vedransemenski.eloranking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApplicationFunctionalTests {


    @BeforeEach
    void setUp() {
    }

    @Test
    void loadingNamesFile_returns0() {
        Application.main(new String[]{"matches", "names", ""});
    }

}
