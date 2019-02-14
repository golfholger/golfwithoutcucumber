package de.itagile.golf.befehl;

import de.itagile.golf.Befehl;
import de.itagile.golf.BefehleSammler;
import de.itagile.golf.Operation;
import de.itagile.golf.operation.Hilfe;

import java.util.List;

import static java.util.Arrays.asList;

public class HilfeBefehl implements Befehl {

    public List<String> kommando() {
        return asList("Hilfe", "h");
    }

    public Operation operation() {
        return new Hilfe(new BefehleSammler());
    }

    public String beschreibung() {
        return "dann zeige ich Dir das hier";
    }

}
