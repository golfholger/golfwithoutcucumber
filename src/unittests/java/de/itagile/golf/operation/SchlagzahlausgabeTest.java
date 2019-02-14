package de.itagile.golf.operation;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import de.itagile.golf.Operation;
import de.itagile.golf.Scorecard;

public class SchlagzahlausgabeTest {

	private final Scorecard scorecard = mock(Scorecard.class);
	private final Operation ausgabe = new Ausgabe();
	
	@Test
	public void meldetEinenSchlag() {
		when(scorecard.anzahlSchlaege()).thenReturn(1);
		assertThat(ausgabe.fuehreAus(scorecard), containsString("1 Schlag"));
	}

}
