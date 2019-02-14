package de.itagile.golf.operation;

import de.itagile.golf.Operation;
import de.itagile.golf.Scorecard;

public class ScorecardAnzeigen implements Operation {
    @Override
    public String fuehreAus(Scorecard scorecard) {
        StringBuilder ausgabe = new StringBuilder("Das ist deine Scorecard\n");
        for (int loch = 1; loch <= scorecard.getGesamtAnzahlLoecher(); loch++) {
            final int schlaegeFuerLoch = scorecard.getSchlaegeFuerLoch(loch);
            ausgabe.append("Loch ")
                    .append(loch)
                    .append(" -> ")
                    .append(schlaegeFuerLoch)
                    .append(schlaegeFuerLoch == 1 ? " Schlag" : " Schläge")
                    .append(" (Par: ").append(scorecard.getParForLoch(loch)).append(")")
                    .append("\n");
        }

        return ausgabe.toString();
    }
}
