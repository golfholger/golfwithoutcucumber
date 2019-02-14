package de.itagile.golf.operation;

import de.itagile.golf.Operation;
import de.itagile.golf.Scorecard;

public class Undo implements Operation {

	private final Operation folgeoperation;

	public Undo(final Operation folgeoperation) {
		this.folgeoperation = folgeoperation;
	}

	@Override
	public String fuehreAus(final Scorecard scorecard) {
		scorecard.undo();
		return folgeoperation.fuehreAus(scorecard);
	}
}
