package de.lv1871.dojos.csv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CsvTabelliererTest {
    private CsvTabellierer tabellierer = new CsvTabellierer();

    @Test
    void sanityTest() {
        // given
        String[] eingabeZeilen = new String[]{
                "Name;Strasse;Ort;Alter",
                "Peter Pan;Am Hang 5;12345 Einsam;42",
                "Maria Schmitz;Kölner Straße 45;50123 Köln;43",
                "Paul Meier;Münchener Weg 1;87654 München;65",
        };
        String[] expected = new String[]{
                "Name         |Strasse         |Ort          |Alter|",
                "-------------+----------------+-------------+-----+",
                "Peter Pan    |Am Hang 5       |12345 Einsam |42   |",
                "Maria Schmitz|Kölner Straße 45|50123 Köln   |43   |",
                "Paul Meier   |Münchener Weg 1 |87654 München|65   |",
        };
        // when
        String[] result = tabellierer.tabelliere(eingabeZeilen);
        // then
        assertArrayEquals(expected, result, "Formattierung ist nicht korrekt.");
    }
}
