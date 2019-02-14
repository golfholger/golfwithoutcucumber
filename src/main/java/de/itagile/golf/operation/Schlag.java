package de.itagile.golf.operation;

import de.itagile.golf.Operation;
import de.itagile.golf.Scorecard;

public final class Schlag implements Operation {
	
	private final Operation ausgabe;

	public Schlag(final Operation folgeoperation) {
		this.ausgabe = folgeoperation;
	}
	
	public String fuehreAus(final Scorecard scorecard) {
		scorecard.erhoeheAnzahlSchlaege();
		return ausgabe.fuehreAus(scorecard);
	}

}