package de.itagile.golf.operation;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import de.itagile.golf.GolfPlatz;
import org.junit.Test;

import de.itagile.golf.EinfacheScorecard;
import de.itagile.golf.Scorecard;

public class LochausgabeTest {

	@Test
	public void gibtErstesLochAus() {
		final Scorecard scorecard = new EinfacheScorecard(mock(GolfPlatz.class));
		assertThat(new Ausgabe().fuehreAus(scorecard ), containsString("1. Loch"));
	}
	@Test
	public void gibtAktuellesLochAus() {
		final Scorecard scorecard = mock(Scorecard.class);
		when(scorecard.aktuellesLoch()).thenReturn(42);
		assertThat(new Ausgabe().fuehreAus(scorecard ), containsString("42. Loch"));
	}
}
