package de.lv1871.dojos.csv;

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
        StringBuilder sep = new StringBuilder();
        for (int j = 0; j < zeile.length(); j++){
            sep.append('-');
        }
        sep.append('+');
        return sep.toString();
    }
}
