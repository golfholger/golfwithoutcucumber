package de.itagile.golf;

import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import org.hamcrest.Matcher;

import de.itagile.golf.util.SystemProperties;

public class TrackerDriver {

	private Process process;
	private BufferedReader reader;
	private PrintWriter writer;
	private String letzteAntwort;
	
    public void starte() {
        process = starteProzess();
        reader = readerFor(process);
        writer = writerFor(process);
        speichereAntwort();
    }

    public void beende() {
        process.destroy();
    }

    private PrintWriter writerFor(final Process process) {
		return new PrintWriter(new OutputStreamWriter(process.getOutputStream()), true);
	}

	private BufferedReader readerFor(final Process process) {
		return new BufferedReader(new InputStreamReader(process.getInputStream()));
	}

	private Process starteProzess() {
		try {
			final String command = String.format(
					"java -Dfile.encoding=%s -jar %s", 
					SystemProperties.FILE_ENCODING,
					"build/libs/nerd-golf-tracker.jar");
			return Runtime.getRuntime().exec(
					command);
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void gibEin(final String anweisung) {
		writer.println(anweisung);
		speichereAntwort();
	}
	
	public String letzteAntwort() {
		return letzteAntwort;
	}

	private void speichereAntwort() {
		try {
			letzteAntwort = readOutputFrom(reader);
		} catch (final IOException exception) {
			throw new RuntimeException(exception);
		}
	}

	public boolean isGolfTrackerAlive() {
    	return process.isAlive();
	}

	private String readOutputFrom(final BufferedReader reader) throws IOException {
		final StringBuilder collector = new StringBuilder();
		collector.append(reader.readLine());
		while (reader.ready()) {
			collector.append(reader.readLine());
		}
		return collector.toString();
	}

	public void assertThatAntwort(final Matcher<String> matcher) {
		assertThat(letzteAntwort(), matcher);
	}
}