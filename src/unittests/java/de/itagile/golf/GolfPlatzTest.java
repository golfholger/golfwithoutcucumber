package de.itagile.golf;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GolfPlatzTest {

    GolfPlatz golfPlatz = new GolfPlatz();

    @Test
    public void shouldGetParForLoch1(){
        assertEquals(4, golfPlatz.getParForLoch(1));
    }
    @Test
    public void shouldGetParForLoch0(){
        assertEquals(0, golfPlatz.getParForLoch(0));
    }
    @Test
    public void shouldGetParForLoch19(){
        assertEquals(0, golfPlatz.getParForLoch(19));
    }
    @Test
    public void shouldGetParForLoch20(){
        assertEquals(0, golfPlatz.getParForLoch(20));
    }
}