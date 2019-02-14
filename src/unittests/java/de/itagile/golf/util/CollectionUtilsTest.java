package de.itagile.golf.util;

import static java.util.Arrays.asList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import static de.itagile.golf.util.CollectionUtils.join;

import java.util.Arrays;

import org.junit.Test;

public class CollectionUtilsTest {

	@Test
	public void joinsEmptyCollectionToEmptyString() {
		assertThat(join(Arrays.asList(), ""), is(""));
	}
	@Test
	public void joinsElementsOfCollectionUsingSeparator() {
		assertThat(join(asList(1, 2), ", "), is("1, 2"));
	}
}
