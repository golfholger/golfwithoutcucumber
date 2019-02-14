package de.itagile.golf.befehl;

import de.itagile.golf.Befehl;
import de.itagile.golf.operation.*;

import java.util.List;

import static java.util.Arrays.asList;

public class UndoBefehl implements Befehl {

	public Undo operation() {
		return new Undo(new Ausgabe());
	}

	public List<String> kommando() {
		return asList("Undo", "u");
	}

	public String beschreibung() {
		return "dann mache ich deine letzte Aktion rückgängig";
	}

}
