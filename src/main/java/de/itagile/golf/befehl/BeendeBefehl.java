package de.itagile.golf.befehl;

import de.itagile.golf.Befehl;
import de.itagile.golf.Operation;
import de.itagile.golf.operation.Beenden;

import java.util.List;

import static java.util.Arrays.asList;

public class BeendeBefehl implements Befehl {

    @Override
    public List<String> kommando() {
        return asList("Beenden", "b");
    }

    @Override
    public Operation operation() {
        return new Beenden();
    }

    @Override
    public String beschreibung() {
        return "Hiermit beendest du das Spiel";
    }
}
