package com.vedransemenski.eloranking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;

class ApplicationFunctionalTests {

    @BeforeEach
    void setUp() {
    }

    @Test
    void loadingFiles_returns0() throws URISyntaxException {
        Application.main(new String[]{"src/test/resources/matches", "src/test/resources/names", "command"});
    }

}
