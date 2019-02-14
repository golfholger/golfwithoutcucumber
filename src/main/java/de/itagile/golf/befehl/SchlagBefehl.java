package de.itagile.golf.befehl;

import de.itagile.golf.Befehl;
import de.itagile.golf.operation.Ausgabe;
import de.itagile.golf.operation.Schlag;

import java.util.List;

import static java.util.Arrays.asList;

public class SchlagBefehl implements Befehl {

	public Schlag operation() {
		return new Schlag(new Ausgabe());
	}

	public List<String> kommando() {
		return asList("Schlage Ball", "sb");
	}

	public String beschreibung() {
		return "dann zähle ich mit";
	}

}
