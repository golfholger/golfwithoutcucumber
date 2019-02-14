package de.itagile.golf.operation;

import de.itagile.golf.Scorecard;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ScorecardAnzeigenTest {

    private final Scorecard scorecard = mock(Scorecard.class);
    private ScorecardAnzeigen scorecardAnzeigen = new ScorecardAnzeigen();

    @Test
    public void fuehreAus() {
        when(scorecard.getSchlaegeFuerLoch(1)).thenReturn(1);
        when(scorecard.getSchlaegeFuerLoch(2)).thenReturn(3);
        when(scorecard.getGesamtAnzahlLoecher()).thenReturn(18);
        when(scorecard.getParForLoch(1)).thenReturn(4);
        when(scorecard.getParForLoch(2)).thenReturn(5);

        assertEquals(
                "Das ist deine Scorecard\n"
                        + "Loch 1 -> 1 Schlag (Par: 4)\n"
                        + "Loch 2 -> 3 Schläge (Par: 5)\n"
                        + "Loch 3 -> 0 Schläge (Par: 0)\n"
                        + "Loch 4 -> 0 Schläge (Par: 0)\n"
                        + "Loch 5 -> 0 Schläge (Par: 0)\n"
                        + "Loch 6 -> 0 Schläge (Par: 0)\n"
                        + "Loch 7 -> 0 Schläge (Par: 0)\n"
                        + "Loch 8 -> 0 Schläge (Par: 0)\n"
                        + "Loch 9 -> 0 Schläge (Par: 0)\n"
                        + "Loch 10 -> 0 Schläge (Par: 0)\n"
                        + "Loch 11 -> 0 Schläge (Par: 0)\n"
                        + "Loch 12 -> 0 Schläge (Par: 0)\n"
                        + "Loch 13 -> 0 Schläge (Par: 0)\n"
                        + "Loch 14 -> 0 Schläge (Par: 0)\n"
                        + "Loch 15 -> 0 Schläge (Par: 0)\n"
                        + "Loch 16 -> 0 Schläge (Par: 0)\n"
                        + "Loch 17 -> 0 Schläge (Par: 0)\n"
                        + "Loch 18 -> 0 Schläge (Par: 0)\n"
                ,
                scorecardAnzeigen.fuehreAus(scorecard)
        );
    }
}
