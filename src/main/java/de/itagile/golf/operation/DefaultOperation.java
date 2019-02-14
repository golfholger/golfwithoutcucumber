package de.itagile.golf.operation;

import de.itagile.golf.Operation;
import de.itagile.golf.Scorecard;

public class DefaultOperation implements Operation {

    private final Operation schlag;

    public DefaultOperation(final Operation folgeoperation) {
        this.schlag = folgeoperation;
    }

    public String fuehreAus(final Scorecard scorecard) {
        return schlag.fuehreAus(scorecard);
    }

}
