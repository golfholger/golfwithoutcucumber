package de.itagile.golf.konsole;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class KonsoleEncodingTest {
	
	@Test
	public void ersetztCp1252DurchCp850FuerWindowsKonsolen() {
		assertThat(KonsoleEncoding.fuerSystemEncoding("Cp1252"), is("Cp850"));
	}
	
	@Test
	public void waehltUtf8Andernfalls() {
		assertThat(KonsoleEncoding.fuerSystemEncoding("foo"), is("UTF-8"));
	}
}
