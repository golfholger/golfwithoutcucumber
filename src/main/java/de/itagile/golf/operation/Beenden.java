package de.itagile.golf.operation;

import de.itagile.golf.Operation;
import de.itagile.golf.Scorecard;

public class Beenden implements Operation {

	@Override
	public String fuehreAus(final Scorecard scorecard) {
		if( scorecard.gesamtanzahlSchlaege()  == 1){
			throw new BeendenException("Du hast 1 Schlag gemacht.");
		}
		throw new BeendenException("Du hast " + scorecard.gesamtanzahlSchlaege() + " Schläge gemacht.");
	}
}
