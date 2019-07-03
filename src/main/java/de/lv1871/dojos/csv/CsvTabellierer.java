package de.lv1871.dojos.csv;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CsvTabellierer {
    public String[] tabelliere(String... eingabeZeilen) {
        if (eingabeZeilen.length > 0) {
            String[] result = new String[eingabeZeilen.length + 1];
            int tabelleIndex = 0;
            for (int i = 0; i < eingabeZeilen.length; i++) {
                String zeile = eingabeZeilen[i];
                result[tabelleIndex++] = zeile + '|';
                if (i == 0) {
                    String sep = createSeparator(zeile);
                    result[tabelleIndex++] = sep;
                }
            }
            return result;
        }
        return new String[0];
    }

    private String createSeparator(String zeile) {
        StringBuilder buffer = new StringBuilder();
        for (int j = 0; j < zeile.length(); j++){
            buffer.append('-');
        }
        buffer.append('+');
        return buffer.toString();
    }

    public List<String> tabelliere(List<String> eingabeZeilen) {
        List<String> result = Collections.emptyList();
        if (eingabeZeilen != null) {
            String[] prepared = eingabeZeilen.toArray(new String[0]);
            String[] tabelliere = tabelliere(prepared);
            result = Arrays.asList(tabelliere);
        }
        return result;
    }
}
