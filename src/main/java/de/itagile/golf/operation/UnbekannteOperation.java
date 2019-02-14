package de.itagile.golf.operation;

import de.itagile.golf.Operation;
import de.itagile.golf.Scorecard;

public class UnbekannteOperation implements Operation {
    private final Operation hilfe;

    public UnbekannteOperation(final Hilfe hilfe) {
        this.hilfe = hilfe;
    }

    @Override
    public String fuehreAus(final Scorecard scorecard) {
        return "Unbekannter Befehl! " + hilfe.fuehreAus(scorecard);
    }
}
