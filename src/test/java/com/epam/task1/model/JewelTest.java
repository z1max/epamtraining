package com.epam.task1.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class JewelTest {

    private Jewel diamond;
    private Jewel amethyst;
    private Jewel aquamarine;

    @Before
    public void setUp() throws Exception {
        diamond = new Jewel("Diamond", 0.5, 100000, 2.418);
        amethyst = new Jewel("Amethyst", 0.7, 60000, 1.543);
        aquamarine = new Jewel("Aquamarine", 0.4, 70000, 1.564);
    }

    @Test
    public void toStringTest() {
        String expected = "com.epam.task1.model.Jewel{name='Diamond', weight=0.5, price=100000, refractiveIndex=2.418}";
        assertEquals(expected, diamond.toString());
    }

    @Test
    public void equalsTest() {
        assertEquals(diamond, diamond);
        assertNotEquals(diamond, amethyst);
        assertNotEquals(diamond, null);
        Jewel test =  new Jewel("Diamond", 0.5, 100000, 2.418);
        assertEquals(diamond, test);
    }

    @Test
    public void hashCodeTest() {
        System.out.println(diamond.hashCode());
        System.out.println(amethyst.hashCode());
        System.out.println(aquamarine.hashCode());
        Jewel test =  new Jewel("Diamond", 0.5, 100000, 2.418);
        assertEquals(diamond.hashCode(), test.hashCode());

    }
}