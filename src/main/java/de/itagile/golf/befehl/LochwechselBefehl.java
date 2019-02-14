package de.itagile.golf.befehl;

import de.itagile.golf.Befehl;
import de.itagile.golf.operation.Ausgabe;
import de.itagile.golf.operation.Lochwechsel;

import java.util.List;

import static java.util.Arrays.asList;

public class LochwechselBefehl implements Befehl {

	public Lochwechsel operation() {
		return new Lochwechsel(new Ausgabe());
	}

	public List<String> kommando() {
		return asList("Nächstes Loch", "nl");
	}

	public String beschreibung() {
		return "dann zähle ich für das nächste Loch mit";
	}

}
