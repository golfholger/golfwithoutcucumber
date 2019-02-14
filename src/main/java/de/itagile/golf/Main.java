package de.itagile.golf;

import java.io.IOException;

import de.itagile.golf.konsole.Konsole;
import de.itagile.golf.operation.Ausgabe;
import de.itagile.golf.operation.BeendenException;

public class Main {
	
	public static void main(final String[] args) throws IOException {
		final Konsole konsole = new Konsole();
		
		final Ausgabe startAusgabe = new Ausgabe();
		final Tracker tracker = new Tracker(new EinfacheScorecard(new GolfPlatz()), new EinfacherInterpreter(new BefehleSammler()), startAusgabe);

		konsole.println(tracker.starte()).beendeAusgabe();

		boolean running = true;
		while (running) {
			final String befehl = konsole.liesZeileEin();
			try {
				konsole.println(tracker.reagiereAuf(befehl)).beendeAusgabe();
			} catch (final BeendenException e) {
				running = false;
				konsole.println(e.getMessage()).beendeAusgabe();
			}
		}
	}
}
