package de.itagile.golf.befehl;

import de.itagile.golf.Befehl;
import de.itagile.golf.Operation;
import de.itagile.golf.operation.Ausgabe;
import de.itagile.golf.operation.ZwischenergebnisAnzeigen;

import java.util.List;

import static java.util.Arrays.asList;

public class ZwischenergebnisAnzeigenBefehl implements Befehl {

    @Override
    public List<String> kommando() {
        return asList("Zwischenergebnis anzeigen", "za");
    }

    @Override
    public Operation operation() {
        return new ZwischenergebnisAnzeigen();
    }

    @Override
    public String beschreibung() {
        return "Zeigt das Zwischenergebnis an.";
    }
}
