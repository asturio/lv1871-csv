package de.lv1871.dojos.csv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void whenNoInput_thenReturnEmptyTable() {
        // when
        String[] result = tabellierer.tabelliere();
        // then
        assertNotNull(result, "Wenn keine Zeilen vorhanden ist soll eine leere Tabelle kommen.");
        assertEquals(0, result.length);
    }

    @Test
    void whenOnlyOneColumnWith3Letters_headerContainsOnlyThisColumn() {
        // when
        String[] result = tabellierer.tabelliere("Foo");
        // then
        assertEquals(2, result.length);
        assertEquals("Foo|", result[0]);
        assertEquals("---+", result[1]);
    }

    @Test
    void whenOnlyOneColumnWith5Letters_headerContainsOnlyThisColumn() {
        // when
        String[] result = tabellierer.tabelliere("Header");
        // then
        assertEquals(2, result.length);
        assertEquals("Header|", result[0]);
        assertEquals("------+", result[1]);
    }

    @Test
    void testHeaderWith2Columns() {
        // when
        String[] result = tabellierer.tabelliere("Header1;Header2");
        // then
        assertEquals("Header1|Header2|", result[0]);
        assertEquals("-------+-------+", result[1]);
    }

    @Test
    void testOneColumnWithOneDataLine() {
        // given
        // when
        String[] result = tabellierer.tabelliere("Header", "Data");
        // then
        assertEquals(3, result.length);
        assertEquals("Header|", result[0]);
        assertEquals("------+", result[1]);
        assertEquals("Data  |", result[2]);
    }


    @Test
    void tabelliereMit4Zeilen() {
        // given
        String[] eingabeZeilen = new String[]{
                "Name;Strasse;Ort;Alter",
                "Peter Pan;Am Hang 5;12345 Einsam;42",
                "Maria Schmitz;Kölner Straße 45;50123 Köln;43",
                "Paul Meier;Münchener Weg 1;87654 München;65",
                "Paul Heise;Münchener Strasse 1860;82654 München;66",
                "Bob Marley;Jamaika Alle 23;87634 Jah;38",
        };
        String[] expected = new String[]{
                "Name         |Strasse               |Ort          |Alter|",
                "-------------+----------------------+-------------+-----+",
                "Peter Pan    |Am Hang 5             |12345 Einsam |42   |",
                "Maria Schmitz|Kölner Straße 45      |50123 Köln   |43   |",
                "\u000c",
                "Name         |Strasse               |Ort          |Alter|",
                "-------------+----------------------+-------------+-----+",
                "Paul Meier   |Münchener Weg 1       |87654 München|65   |",
                "Paul Heise   |Münchener Strasse 1860|82654 München|66   |",
                "\u000c",
                "Name         |Strasse               |Ort          |Alter|",
                "-------------+----------------------+-------------+-----+",
                "Bob Marley   |Jamaika Alle 23       |87634 Jah    |38   |",
        };
        // when
        String[] result = tabellierer.tabelliere(4, eingabeZeilen);
        // then
        assertArrayEquals(expected, result, "Formattierung ist nicht korrekt.");
    }


}
