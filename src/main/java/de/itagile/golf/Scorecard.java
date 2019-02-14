package de.itagile.golf;

public interface Scorecard {

	void erhoeheAnzahlSchlaege();

	int anzahlSchlaege();

	void schliesseLochAb();

	int aktuellesLoch();

	void undo();

    int gesamtanzahlSchlaege();

	int getParForAktuellesLoch();

	int getSchlaegeFuerLoch(int loch);

	int getGesamtAnzahlLoecher();

    int getParForLoch(int loch);
}
