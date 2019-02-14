package de.itagile.golf.operation;

import de.itagile.golf.Operation;
import de.itagile.golf.Scorecard;

public final class Lochwechsel implements Operation {
	
	private final Operation ausgabe;

	public Lochwechsel(final Operation folgeoperation) {
		this.ausgabe = folgeoperation;
	}

	public String fuehreAus(final Scorecard scorecard) {

		if(scorecard.anzahlSchlaege()>0){
			scorecard.schliesseLochAb();
			return ausgabe.fuehreAus(scorecard);
		}else{
			throw new GolfTrackerException("Es muss zunächst ein Schlag ausgeführt werden");
		}

	}
}