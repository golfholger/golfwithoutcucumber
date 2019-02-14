Feature: Aktuelles Loch anzeigen
    
    Scenario: direkt nach dem Start
        When ich den NerdGolfTracker starte
        Then kommt das Ergebnis 1. Loch
    
    Scenario: auf dem 2. Loch
        When ich 1-mal den Befehl Schlage Ball eingebe
        When ich 1-mal den Befehl Nächstes Loch eingebe
        Then kommt das Ergebnis 2. Loch

