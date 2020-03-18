package com.vedransemenski.eloranking;

import org.junit.jupiter.api.Test;

class FileImportFunctionalTest extends ConsoleLineFunctionalTest {

    @Test
    void loadingFiles_returns0() {
        Application.main(new String[]{"src/test/resources/matches", "src/test/resources/names"});
    }

}
