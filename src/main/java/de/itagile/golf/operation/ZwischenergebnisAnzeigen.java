package de.itagile.golf.operation;

import de.itagile.golf.Operation;
import de.itagile.golf.Scorecard;

public class ZwischenergebnisAnzeigen extends Ausgabe {

    public ZwischenergebnisAnzeigen() {
    }

    @Override
    public String fuehreAus(final Scorecard scorecard) {
        return super.fuehreAus(scorecard) + " Insgesamt hast du " + numberOfSchlaegeText(scorecard.gesamtanzahlSchlaege()) + ".";
    }

}
