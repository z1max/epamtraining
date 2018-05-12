package com.epam.task1.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NecklaceTest {

    private Necklace necklace1;
    private Necklace necklace2;

    @Before
    public void setUp() throws Exception {
        necklace1 = new Necklace("Test",
                new Jewel("Diamond", 0.5, 100000, 2.418),
                new Jewel("Amethyst", 0.7, 60000, 1.543),
                new Jewel("Aquamarine", 0.4, 70000, 1.564));
        necklace2 = new Necklace("Necklace",
                new Jewel("Alexandrite", 2, 200000, 1.745),
                new Jewel("Jade", 4, 800000, 1.8)
        );
    }

    @Test
    public void toStringTest() {
        String expected = "com.epam.task1.model.Necklace{name='Test', jewels=[" +
                "com.epam.task1.model.Jewel{name='Diamond', weight=0.5, price=100000, refractiveIndex=2.418}, " +
                "com.epam.task1.model.Jewel{name='Amethyst', weight=0.7, price=60000, refractiveIndex=1.543}, " +
                "com.epam.task1.model.Jewel{name='Aquamarine', weight=0.4, price=70000, refractiveIndex=1.564}]}";
        assertEquals(expected, necklace1.toString());
    }

    @Test
    public void equalsTest() {
        assertEquals(necklace1, necklace1);
        assertNotEquals(necklace1, null);
        assertNotEquals(necklace1, necklace2);
        Necklace test = necklace2 = new Necklace("Necklace",
                new Jewel("Alexandrite", 2, 200000, 1.745),
                new Jewel("Jade", 4, 800000, 1.8)
        );
        assertEquals(necklace2, test);
    }

    @Test
    public void hashCodeTest() {
        System.out.println(necklace1.hashCode());
        System.out.println(necklace2.hashCode());
        Necklace test = necklace2 = new Necklace("Necklace",
                new Jewel("Alexandrite", 2, 200000, 1.745),
                new Jewel("Jade", 4, 800000, 1.8)
        );
        assertEquals(necklace2.hashCode(), test.hashCode());
    }
}