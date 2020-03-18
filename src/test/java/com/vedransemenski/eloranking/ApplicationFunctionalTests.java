package com.vedransemenski.eloranking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApplicationFunctionalTests {

    public static final String RESOURCES_MATCHES = "src/test/resources/matches";
    public static final String RESOURCES_NAMES = "src/test/resources/names";
    public static final String RESOURCES_OUTPUT = "src/test/resources/output";

    @BeforeEach
    void setUp() {
    }

    @Test
    void loadingFiles() {
        Application.main(new String[]{RESOURCES_MATCHES, RESOURCES_NAMES});
    }

    @Test
    void showRanking() {
        Application.main(new String[]{RESOURCES_MATCHES, RESOURCES_NAMES, RESOURCES_OUTPUT, "show_ranking"});
    }

    @Test
    void showReport() {
        Application.main(new String[]{RESOURCES_MATCHES, RESOURCES_NAMES, RESOURCES_OUTPUT, "show_report", "0"});
    }
}
