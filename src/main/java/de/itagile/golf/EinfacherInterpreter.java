package de.itagile.golf;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import de.itagile.golf.operation.Hilfe;
import de.itagile.golf.operation.UnbekannteOperation;


public class EinfacherInterpreter implements Interpreter {

    private final Map<String, Operation> operationen = new HashMap<>();
    private final Operation unbekannteOperation = new UnbekannteOperation(new Hilfe(new BefehleSammler()));

    private BefehleSammler befehleSammler;
    EinfacherInterpreter(BefehleSammler befehleSammler) {
        this.befehleSammler = befehleSammler;
        befehleSammler.sammle().forEach(befehl -> befehl.kommando().forEach(kommando -> {
            operationen.put(kommando.toLowerCase(Locale.ENGLISH), befehl.operation());
        }));
    }

    @Override
    public Operation interpretiere(final String inputString) {
        return operationen.getOrDefault(inputString.toLowerCase(Locale.ENGLISH), unbekannteOperation);
    }
}
