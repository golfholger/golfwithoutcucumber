package de.itagile.golf;

import java.util.ArrayList;
import java.util.List;

import de.itagile.golf.befehl.*;

public class BefehleSammler {

	public List<Befehl> sammle() {
		final List<Befehl> ernte = new ArrayList<>();
		ernte.add(new DefaultBefehl());
		ernte.add(new SchlagBefehl());
		ernte.add(new LochwechselBefehl());
		ernte.add(new UndoBefehl());
		ernte.add(new HilfeBefehl());
		ernte.add(new BeendeBefehl());
		ernte.add(new ZwischenergebnisAnzeigenBefehl());
		ernte.add(new ScorecardAnzeigenBefehl());
		return ernte;
	}
}
