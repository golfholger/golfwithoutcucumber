package de.itagile.golf.operation;

import static java.util.Arrays.asList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static de.itagile.golf.util.SystemProperties.LINE_SEPARATOR;

import java.util.Collections;

import org.junit.Test;

import de.itagile.golf.Befehl;
import de.itagile.golf.BefehleSammler;

public class HilfeTest {

	@Test
	public void zeigtIntroAn() {
		assertThat(hilfetext(), containsString("Ich reagiere auf:"));
	}

	@Test
	public void zeigtBeschreibungZumKommando() {
		assertThat(hilfetext(dummyBefehl("Kommando", "Beschreibung")), 
				containsString("Kommando (...Beschreibung)"));
	}

	@Test
	public void gibtProKommandoEineZeileAus() {
		final Befehl befehl = mock(Befehl.class);
		when(befehl.kommando()).thenReturn(Collections.singletonList("Kommando"));
		final String hilfetextFuerZweiBefehle = hilfetext(befehl, befehl);
		assertThat(anzahlZeilen(hilfetextFuerZweiBefehle), is(3));
	}

	private int anzahlZeilen(final String string) {
		final String[] zeilen = string.split(LINE_SEPARATOR);
		return zeilen.length;
	}

	private String hilfetext(final Befehl... befehle) {
		final BefehleSammler sammler = mock(BefehleSammler.class);
		
		final Hilfe hilfe = new Hilfe(sammler);
		when(sammler.sammle()).thenReturn(asList(befehle));
		return hilfe.fuehreAus(null);
	}

	private Befehl dummyBefehl(final String kommando, final String beschreibung) {
		final Befehl befehl = mock(Befehl.class);
		when(befehl.kommando()).thenReturn(Collections.singletonList(kommando));
		when(befehl.beschreibung()).thenReturn(beschreibung);
		return befehl;
	}
}
