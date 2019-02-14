package de.itagile.golf.operation;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import de.itagile.golf.Befehl;
import de.itagile.golf.BefehleSammler;
import de.itagile.golf.Operation;
import de.itagile.golf.Scorecard;
import de.itagile.golf.util.CollectionUtils;
import de.itagile.golf.util.SystemProperties;

public class Hilfe implements Operation {

    private final BefehleSammler sammler;

    public Hilfe(final BefehleSammler sammler) {
        this.sammler = sammler;
    }

    @Override
    public String fuehreAus(final Scorecard scorecard) {
        final List<String> hilfeTexte = new ArrayList<>();
        for (final Befehl befehl : sammler.sammle()) {
            hilfeTexte.add(hilfeZeileFuer(befehl));
        }
        return "Ich reagiere auf: " + SystemProperties.LINE_SEPARATOR + CollectionUtils.join(hilfeTexte, SystemProperties.LINE_SEPARATOR);
    }

    private String hilfeZeileFuer(final Befehl befehl) {
        final StringJoiner aliasListe = new StringJoiner(", ");
        befehl.kommando().forEach(kommando -> {
            if (kommando.equals("")) {
                aliasListe.add("ENTER");
            } else {
                aliasListe.add(kommando);
            }
        });
        return String.format(" * %s (...%s)", aliasListe.toString(), befehl.beschreibung());
    }
}
