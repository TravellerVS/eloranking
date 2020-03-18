package com.vedransemenski.eloranking;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ConsoleLineFunctionalTest {
    private PrintStream console;
    private ByteArrayOutputStream bytes;

    @BeforeEach
    protected void setUp() {
        bytes = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(bytes));
    }

    @AfterEach
    protected void tearDown() {
        System.setOut(console);
    }

    protected String readOutput() {
        return bytes.toString();
    }
}
