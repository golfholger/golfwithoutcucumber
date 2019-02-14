package de.itagile.golf.operation;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import de.itagile.golf.Operation;
import de.itagile.golf.Scorecard;

public class LochwechselausgabeTest {
	
	private final Scorecard scorecard = mock(Scorecard.class);
	private final Ausgabe ausgabe = new Ausgabe();


	@Test
	public void gibParAus(){
		when(scorecard.getParForAktuellesLoch()).thenReturn(42);

		assertThat(ausgabe.fuehreAus(scorecard), containsString("Par ist 42"));
	}
}
