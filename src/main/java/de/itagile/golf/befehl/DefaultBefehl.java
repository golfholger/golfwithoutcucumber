package de.itagile.golf.befehl;

import de.itagile.golf.Befehl;
import de.itagile.golf.Operation;
import de.itagile.golf.operation.*;

import java.util.Collections;
import java.util.List;

public class DefaultBefehl implements Befehl {
    @Override
    public List<String> kommando() {
        return Collections.singletonList("");
    }

    @Override
    public Operation operation() {
        return new DefaultOperation(new Schlag(new Ausgabe()));
    }

    @Override
    public String beschreibung() {
        return "default Befehl zum Ball schlagen";
    }
}
