package de.itagile.golf.operation;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import de.itagile.golf.Scorecard;


public class BeendenTest {

    private final Scorecard scorecard = mock(Scorecard.class);
    private final Beenden beenden = new Beenden();

    @Test
    public void beendetWirftException() {
        try {
            when(scorecard.gesamtanzahlSchlaege()).thenReturn(6);
            beenden.fuehreAus(scorecard);
        } catch (final BeendenException ex) {
            assertEquals("Du hast 6 Schläge gemacht.", ex.getMessage());
        }

    }

    @Test
    public void beendetWirftExceptionEinSchlag() {
        try {
            when(scorecard.gesamtanzahlSchlaege()).thenReturn(1);
            beenden.fuehreAus(scorecard);
        } catch (final BeendenException ex) {
            assertEquals("Du hast 1 Schlag gemacht.", ex.getMessage());
        }

    }

}
