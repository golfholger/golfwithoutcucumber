package de.itagile.golf.operation;

import de.itagile.golf.Scorecard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ZwischenergebnisAnzeigenTest {

    private Scorecard scorecard;

    @Before
    public void setup() {
        scorecard = Mockito.mock(Scorecard.class);
    }

    @Test
    public void emptyScorecard() {
        ZwischenergebnisAnzeigen sut = new ZwischenergebnisAnzeigen();
        String ausgabe = sut.fuehreAus(scorecard);

        Assert.assertEquals("Du bist auf dem 0. Loch, hast 0 Schläge und das Par ist 0. Insgesamt hast du 0 Schläge.", ausgabe);
    }

    @Test
    public void playedScorecard() {
        when(scorecard.aktuellesLoch()).thenReturn(2);
        when(scorecard.anzahlSchlaege()).thenReturn(3);
        when(scorecard.gesamtanzahlSchlaege()).thenReturn(5);

        ZwischenergebnisAnzeigen sut = new ZwischenergebnisAnzeigen();
        String ausgabe = sut.fuehreAus(scorecard);

        Assert.assertEquals("Du bist auf dem 2. Loch, hast 3 Schläge und das Par ist 0. Insgesamt hast du 5 Schläge.", ausgabe);
    }
}