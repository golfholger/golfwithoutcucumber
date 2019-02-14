package de.itagile.golf.operation;

import de.itagile.golf.Operation;
import de.itagile.golf.Scorecard;

public class Ausgabe implements Operation {

    @Override
    public String fuehreAus(final Scorecard scorecard) {

        return "Du bist auf dem " + scorecard.aktuellesLoch() + ". Loch, hast " +
                numberOfSchlaegeText( scorecard.anzahlSchlaege())
                + " und das Par ist " + scorecard.getParForAktuellesLoch() + ".";
    }

    protected String numberOfSchlaegeText(final int anzahlSchlaege){
        final String vorlage;
        if (anzahlSchlaege == 1) {
            vorlage = "%d Schlag";
        } else {
            vorlage = "%d Schläge";
        }

        return String.format(vorlage, anzahlSchlaege);

    }

}
