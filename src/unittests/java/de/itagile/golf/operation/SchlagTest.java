package de.itagile.golf.operation;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import de.itagile.golf.Operation;
import de.itagile.golf.Scorecard;


public class SchlagTest {

	private final Scorecard scorecard = mock(Scorecard.class);
	private final Operation folgeoperation = mock(Operation.class);
	private final Schlag schlag = new Schlag(folgeoperation);

	@Test
	public void erhoehtAnzahlSchlaegeAufScorecard() {
		schlag.fuehreAus(scorecard);
		verify(scorecard).erhoeheAnzahlSchlaege();
	}

	@Test
	public void gibtErgebnisDerFolgeoperationZurueck() {
		when(folgeoperation.fuehreAus(scorecard)).thenReturn("foo");
		assertThat(schlag.fuehreAus(scorecard), is("foo"));
	}
}
