package de.itagile.golf;

import de.itagile.golf.operation.GolfTrackerException;

public class Tracker {

	public Scorecard scorecard;
	private final Interpreter interpreter;
	private Operation startoperation;

	public Tracker(Scorecard scorecard, final Interpreter interpreter, final Operation startoperation) {
		this.scorecard = scorecard;
		this.interpreter = interpreter;
		this.startoperation = startoperation;
	}
	
	public String reagiereAuf(final String eingabe) {
		try {
			return interpreter.interpretiere(eingabe).fuehreAus(scorecard);
		} catch (final GolfTrackerException gte) {
			return gte.getMessage();
		}
	}

	public String starte() {
		return startoperation.fuehreAus(scorecard);
	}
}
