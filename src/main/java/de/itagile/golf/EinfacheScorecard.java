package de.itagile.golf;

import java.util.ArrayList;
import java.util.List;

import de.itagile.golf.operation.GolfTrackerException;

public class EinfacheScorecard implements Scorecard {

	private final GolfPlatz golfPlatz;
	private int aktuellesLoch = 1;
	private int anzahlSchlaege;
	private final List<Integer> lochStaende = new ArrayList<>();

    public EinfacheScorecard(GolfPlatz golfPlatz) {
        this.golfPlatz = golfPlatz;
    }

    public void erhoeheAnzahlSchlaege() {
		anzahlSchlaege++;
	}

	public void schliesseLochAb() {
		aktuellesLoch++;
		lochStaende.add(anzahlSchlaege);
		anzahlSchlaege = 0;
	}

	public int anzahlSchlaege() {
		return anzahlSchlaege;
	}

	public int aktuellesLoch() {
		return aktuellesLoch;
	}

	public void undo(){
		if (anzahlSchlaege  == 0) {
			if (aktuellesLoch == 1) {
				throw new GolfTrackerException("Du bist schon beim ersten Loch und kannst nicht weiter zurück.");
			}
			aktuellesLoch--;
			anzahlSchlaege = lochStaende.get(aktuellesLoch - 1);
			lochStaende.remove(aktuellesLoch - 1);
		} else {
			anzahlSchlaege--;
		}
	}

	public int gesamtanzahlSchlaege() {
		int gesamtanzahlLoecher = 0;
		for (final Integer lochStand : lochStaende) {
			gesamtanzahlLoecher += lochStand;
		}
		gesamtanzahlLoecher += anzahlSchlaege;
		return gesamtanzahlLoecher;

	}

	@Override
	public int getSchlaegeFuerLoch(int loch) {
		if (loch == aktuellesLoch) {
			return anzahlSchlaege;
		}
		if (loch > lochStaende.size()) {
			return 0;
		}
		return lochStaende.get(loch - 1);
	}

    @Override
    public int getGesamtAnzahlLoecher() {
        return golfPlatz.getLochCount();
    }

    @Override
	public int getParForAktuellesLoch() {
		return golfPlatz.getParForLoch(aktuellesLoch);
	}

    @Override
    public int getParForLoch(int loch) {
        return golfPlatz.getParForLoch(loch);
    }
}
