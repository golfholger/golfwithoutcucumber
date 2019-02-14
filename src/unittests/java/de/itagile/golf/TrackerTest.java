package de.itagile.golf;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class TrackerTest {

	private final Interpreter interpreter = mock(Interpreter.class);
	private final Operation startoperation = mock(Operation.class);
	private final Scorecard scorecard = mock(Scorecard.class);
	private final Tracker tracker = new Tracker(scorecard, interpreter, startoperation);

	@Test
	public void gibtErgebnisDerAusgeloestenOperationZurueck() {
		final Operation operation = mock(Operation.class);
		when(interpreter.interpretiere("foo")).thenReturn(operation);
		when(operation.fuehreAus(any(Scorecard.class))).thenReturn("bar");
		assertThat(tracker.reagiereAuf("foo"), is("bar"));
	}
	
	@Test
	public void gibtErgebnisDerStartoperationZurueck() {
		when(startoperation.fuehreAus(any(Scorecard.class))).thenReturn("foo");
		assertThat(tracker.starte(), is("foo"));
	}
}
