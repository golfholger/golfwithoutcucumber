package de.itagile.golf;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import de.itagile.golf.operation.GolfTrackerException;


public class EinfacheScorecardTest {

	private Scorecard scorecard;
	private GolfPlatz mockGolfPlatz;
    @Before
    public void before() {
		mockGolfPlatz = mock(GolfPlatz.class);
        scorecard = new EinfacheScorecard(mockGolfPlatz);
    }
	
	@Test
	public void inkrementiertSchlagzahlEinmal() {
		scorecard.erhoeheAnzahlSchlaege();
		assertThat(scorecard.anzahlSchlaege(), is(1));
	}
	
	@Test
	public void inkrementiertSchlagzahlMehrmals() {
		scorecard.erhoeheAnzahlSchlaege();
		scorecard.erhoeheAnzahlSchlaege();
		assertThat(scorecard.anzahlSchlaege(), is(2));
	}
	
	@Test
	public void setztSchlagzahlZurueck() {
		scorecard.erhoeheAnzahlSchlaege();
		scorecard.schliesseLochAb();
		assertThat(scorecard.anzahlSchlaege(), is(0));
	}
	
	@Test
	public void hatInitialErstesLoch() {
		assertThat(scorecard.aktuellesLoch(), is(1));
	}
	
	@Test
	public void zaehltAktuellesLoch() {
		scorecard.schliesseLochAb();
		assertThat(scorecard.aktuellesLoch(), is(2));
	}

	@Test
	public void nimmLetztenSchlagZurueck() {
		scorecard.erhoeheAnzahlSchlaege();
		scorecard.erhoeheAnzahlSchlaege();
		scorecard.undo();
		assertThat(scorecard.anzahlSchlaege(), is(1));
		assertThat(scorecard.aktuellesLoch(), is(1));

	}

	@Test
	public void nimmLetztesLochZurueck() {
		scorecard.erhoeheAnzahlSchlaege();
		scorecard.erhoeheAnzahlSchlaege();
		scorecard.schliesseLochAb();
		scorecard.undo();
		assertThat(scorecard.anzahlSchlaege(), is(2));
		assertThat(scorecard.aktuellesLoch(), is(1));
	}

	@Test (expected = GolfTrackerException.class)
	public void nimmErstesLochZurueck() {
		scorecard.undo();
	}

	@Test
	public void complexUndo() {
		scorecard.erhoeheAnzahlSchlaege();
		scorecard.erhoeheAnzahlSchlaege();
		scorecard.schliesseLochAb();
		scorecard.undo();
		scorecard.undo();
		scorecard.undo();
		scorecard.erhoeheAnzahlSchlaege();
		scorecard.schliesseLochAb();
		scorecard.undo();
		assertThat(scorecard.anzahlSchlaege(), is(1));
		assertThat(scorecard.aktuellesLoch(), is(1));
	}

	@Test
	public void testParForLoch1() {
    	when(mockGolfPlatz.getParForLoch(1)).thenReturn(4);
    	assertThat(scorecard.getParForAktuellesLoch(), is(4));
	}

	@Test
	public void testParForLoch2() {
    	when(mockGolfPlatz.getParForLoch(2)).thenReturn(5);
    	scorecard.schliesseLochAb();
		assertThat(scorecard.getParForAktuellesLoch(), is(5));
	}

	@Test
	public void getSchlaegeForNewLoch() {
    	assertThat(scorecard.getSchlaegeFuerLoch(1), is(0));
	}

	@Test
	public void getSchlaegeForLochWithSchlaege() {
    	scorecard.erhoeheAnzahlSchlaege();
		assertThat(scorecard.getSchlaegeFuerLoch(1), is(1));
	}
	@Test
	public void getSchlaegeForLochAfterLochwechsel() {
    	scorecard.erhoeheAnzahlSchlaege();
    	scorecard.erhoeheAnzahlSchlaege();
    	scorecard.schliesseLochAb();
    	scorecard.erhoeheAnzahlSchlaege();
		assertThat(scorecard.getSchlaegeFuerLoch(1), is(2));
		assertThat(scorecard.getSchlaegeFuerLoch(2), is(1));
	}

	@Test
	public void getSchlaegeForLochAfterLochwechselUndUndo() {
		scorecard.erhoeheAnzahlSchlaege();
		scorecard.erhoeheAnzahlSchlaege();
		scorecard.schliesseLochAb();
		scorecard.erhoeheAnzahlSchlaege();
		scorecard.undo();
		scorecard.undo();
		scorecard.undo();
		assertThat(scorecard.getSchlaegeFuerLoch(1), is(1));
		assertThat(scorecard.getSchlaegeFuerLoch(2), is(0));
	}
}
