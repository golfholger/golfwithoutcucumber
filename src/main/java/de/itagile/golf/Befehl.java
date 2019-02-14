package de.itagile.golf;

import java.util.List;

public interface Befehl {

	List<String> kommando();

	Operation operation();

	String beschreibung();

}
