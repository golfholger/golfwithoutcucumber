package de.itagile.golf;

import static java.lang.String.valueOf;

import static org.hamcrest.Matchers.containsString;

import cucumber.api.java.en.Then;

public class AusgabeCheckStepdefs {

    private final TrackerDriver trackerDriver;

    public AusgabeCheckStepdefs(final TrackerDriver trackerDriver) {
        this.trackerDriver = trackerDriver;
    }

    @Then("kommt das Ergebnis (.*)")
    public void test(final String consolenOutput) {
        trackerDriver.assertThatAntwort(containsString(valueOf(consolenOutput)));
    }
}
