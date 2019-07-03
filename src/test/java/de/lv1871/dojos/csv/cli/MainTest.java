package de.lv1871.dojos.csv.cli;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class MainTest {
    @Test
    void testExample() throws IOException {
        // This is not really a test
        Main.main(new String[]{"src/test/resources/example.csv"});
    }

    @Test
    void testSample() throws IOException {
        // This is not really a test
        Main.main(new String[]{"src/test/resources/sample.csv"});
    }

}