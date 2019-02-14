package de.itagile.golf;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;

public class NerdGolfTrackerStepdefs {
	
	private final TrackerDriver tracker;

	public NerdGolfTrackerStepdefs(final TrackerDriver tracker) {
		this.tracker = tracker;
	}

	@Before
    public void starteNeuesSpiel() {
        tracker.starte();
    }

	@After
    public void beendeTracker() {
        tracker.beende();
    }

	@When("ich den NerdGolfTracker starte")
    public void starteNerdGolfTracker() {
        // nur da, um lesbarere Szenarien zu schreiben
    }
	
    @When("ich (\\d+)-mal den Befehl (.*) eingebe")
    public void gebeUnbekanntenBefehlEin(String anzahlbefehlString, final String befehl) {
        int anzahlbefehl = Integer.valueOf(anzahlbefehlString);
        while (anzahlbefehl-- > 0) {
            tracker.gibEin(befehl);
        }

    }

}
