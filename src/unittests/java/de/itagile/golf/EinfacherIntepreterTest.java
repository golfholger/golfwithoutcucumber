package de.itagile.golf;

import static org.hamcrest.Matchers.isA;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import de.itagile.golf.operation.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class EinfacherIntepreterTest {

    private final Interpreter interpreter = new EinfacherInterpreter(new BefehleSammler());
    private final String befehl;
    private final Class<? super Operation> operation;

    public EinfacherIntepreterTest(final String befehl, final Class<? super Operation> operation) {
        this.befehl = befehl;
        this.operation = operation;
    }

    @Parameters
    public static List<Object[]> parameters() {
        final Object[][] testData = new Object[][]{
                {"Schlage Ball", Schlag.class},
                {"Nächstes Loch", Lochwechsel.class},
                {"Hilfe", Hilfe.class},
                {"Unbekannter Befehl", UnbekannteOperation.class},
                {"sadasd", UnbekannteOperation.class},
                {"schlage ball", Schlag.class},
                {"nächstes LOCH", Lochwechsel.class},
                {"HILFE", Hilfe.class},
                {"h", Hilfe.class},
                {"sb", Schlag.class},
                {"nl", Lochwechsel.class},
                {"b", Beenden.class},
                {"Beenden", Beenden.class},
                {"", DefaultOperation.class},
                {"Undo", Undo.class},
                {"u", Undo.class},
                {"Zwischenergebnis anzeigen", ZwischenergebnisAnzeigen.class},
                {"za", ZwischenergebnisAnzeigen.class},
                {"Scorecard anzeigen", ScorecardAnzeigen.class}
        };
        return Arrays.asList(testData);
    }

    @Test
    public void interpretiertBefehle() {
        assertThat(interpreter.interpretiere(befehl), isA(operation));
    }
}
