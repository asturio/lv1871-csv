package de.lv1871.dojos.csv.cli;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class MainTest {
    @Test
    void testMain() throws IOException {
        // when
        Main.main(new String[]{"src/main/resources/example.csv"});
        // This is not really a test
    }

}