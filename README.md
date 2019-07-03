# lv1871-csv

Beschriebung siehe bitte hier:

https://ccd-school.de/coding-dojo/function-katas/csv-tabellieren/

## Zusatz Aufgaben

### Parsen von anderen Dateien
Die Datei src/test/resources/sample.csv soll geparst werden, und richtig dargestellt werden. Kann Eure implementierung 
schon damit umgehen?

### Seitenumbruch
Schreibe eine neue Methode, die neben den Zeilen auch noch einen int-Parameter bekommt, der angibt, wie viele Zeilen 
pro Seite ausgegeben werden können. Die Seite ist voll, wenn diese Anzahl erreicht wird. In diesem Fall soll eine leere 
Zeile erstellt werden (wahlweise mit einem Seitenvorschub-Zeichen `\u000c`), dann soll der Header wieder ausgegeben 
werden, und weitere Tabellen Zeilen.

Beispiel:

Aus den Eingaben:
```csv
Name;Strasse;Ort;Alter
Peter Pan;Am Hang 5;12345 Einsam;42
Maria Schmitz;Kölner Straße 45;50123 Köln;43
Paul Meier;Münchener Weg 1;87654 München;65
```
und **4** Zeilen pro Seite, soll das Ergebnis sein:

<pre>
Name         |Strasse         |Ort          |Alter|
-------------+----------------+-------------+-----+
Peter Pan    |Am Hang 5       |12345 Einsam |42   |
Maria Schmitz|Kölner Straße 45|50123 Köln   |43   |

Name         |Strasse         |Ort          |Alter|
-------------+----------------+-------------+-----+
Paul Meier   |Münchener Weg 1 |87654 München|65   |
</pre>