package de.lv1871.dojos.csv.cli;

import de.lv1871.dojos.csv.CsvTabellierer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        CsvTabellierer tabellierer = new CsvTabellierer();
        for (String fileName : args) {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            List<String> formatted = tabellierer.tabelliere(lines);
            System.out.println(fileName);
            for (String line : formatted) {
                System.out.println(line);

            }
        }
    }
}
