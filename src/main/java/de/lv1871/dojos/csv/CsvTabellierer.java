package de.lv1871.dojos.csv;

import java.util.*;

public class CsvTabellierer {
    public String[] tabelliere(int zeilenProSeite, String... eingabeZeilen) {
        if (eingabeZeilen.length > 0) {
            Map<Integer, Integer> lengths = scanColumnLengths(eingabeZeilen);
            return createTable(eingabeZeilen, lengths, zeilenProSeite);
        }
        return new String[0];
    }
    public String[] tabelliere(String... eingabeZeilen) {
        return tabelliere(0, eingabeZeilen);
    }

    private String[] createTable(String[] eingabeZeilen, Map<Integer, Integer> lengths, int linesPerPage) {
        List<String> result = new ArrayList<>();

        String header = createLine(lengths, eingabeZeilen[0]);
        String headerSeparator = createLineSeparator(lengths);
        int anzahlZeilen = 0;
        for (String zeile : eingabeZeilen) {
            if (result.isEmpty() || (linesPerPage > 2 && anzahlZeilen % linesPerPage == 0)) {
                if (!result.isEmpty()) {
                    result.add("\u000c");
                }

                result.add(header);
                result.add(headerSeparator);
                anzahlZeilen += 2;
                if (anzahlZeilen == 2) {
                    continue;
                }
            }
            result.add(createLine(lengths, zeile));
            anzahlZeilen++;
        }
        return result.toArray(new String[0]);
    }

    public List<String> tabelliere(List<String> eingabeZeilen) {
        List<String> result = Collections.emptyList();
        if (eingabeZeilen != null) {
            String[] lines = eingabeZeilen.toArray(new String[0]);
            String[] resultArray = tabelliere(lines);
            result = Arrays.asList(resultArray);
        }
        return result;
    }

    private Map<Integer, Integer> scanColumnLengths(String[] eingabeZeilen) {
        Map<Integer, Integer> lengths = new HashMap<>();
        for (String zeile : eingabeZeilen) {
            scanColumnLengthsInLine(zeile, lengths);
        }
        return lengths;
    }

    private void scanColumnLengthsInLine(String line, Map<Integer, Integer> lengths) {
        String[] parts = line.split(";");
        for (int index = 0; index < parts.length; index++) {
            Integer length = lengths.get(index);
            String part = parts[index];
            if (length == null || length < part.length()) {
                lengths.put(index, part.length());
            }
        }
    }

    private String createLine(Map<Integer, Integer> lengths, String line) {
        StringBuilder builder = new StringBuilder();
        String[] cells = line.split(";");
        for (Integer columnIndex : lengths.keySet()) {
            int fillerLength = lengths.get(columnIndex);
            if (columnIndex < cells.length) {
                String cell = cells[columnIndex];
                builder.append(cell);
                fillerLength -= cell.length();
            }
            builder.append(filler(fillerLength)).append('|');
        }

        return builder.toString();
    }

    private String filler(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(' ');
        }
        return builder.toString();
    }

    private String createLineSeparator(Map<Integer, Integer> lengths) {
        StringBuilder lineSeparator = new StringBuilder();
        for (int i = 0; i < lengths.size(); i++) {
            lineSeparator.append(createSeparatorForSingleColumn(lengths.get(i)));
        }
        return lineSeparator.toString();
    }

    private String createSeparatorForSingleColumn(int columnLength) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < columnLength; i++) {
            builder.append('-');
        }
        builder.append('+');
        return builder.toString();
    }

}
