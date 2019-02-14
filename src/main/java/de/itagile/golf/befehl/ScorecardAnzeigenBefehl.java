package de.itagile.golf.befehl;

import de.itagile.golf.Operation;
import de.itagile.golf.operation.ScorecardAnzeigen;

import java.util.List;

import static java.util.Arrays.asList;

public class ScorecardAnzeigenBefehl implements de.itagile.golf.Befehl {
    @Override
    public List<String> kommando() {
        return asList("Scorecard anzeigen", "sa");
    }

    @Override
    public Operation operation() {
        return new ScorecardAnzeigen();
    }

    @Override
    public String beschreibung() {
        return "dann zeige ich die Scorecard an";
    }
}
