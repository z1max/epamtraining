package com.emap.task1.util;

import com.epam.task1.model.Jewel;
import com.epam.task1.model.Necklace;
import com.epam.task1.util.NecklaceUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class NecklaceUtilTest {

    private Necklace necklace;
    private NecklaceUtil necklaceUtil;

    @Before
    public void setUp() throws Exception {
        necklace = new Necklace(
                "Test",
                new Jewel("Diamond", 0.5, 100000, 2.418),
                new Jewel("Amethyst", 0.7, 60000, 1.543),
                new Jewel("Aquamarine", 0.4, 70000, 1.564));
        necklaceUtil = new NecklaceUtil();
        necklaceUtil.setNecklace(necklace);
    }

    @After
    public void tearDown() throws Exception {
        necklace = null;
        necklaceUtil = null;
    }

    @Test
    public void summaryWeight() {
        assertThat(necklaceUtil.summaryWeight(), equalTo(1.6));
    }

    @Test
    public void summaryPrice() {
        assertThat(necklaceUtil.summaryPrice(), equalTo(230000L));
    }

    @Test
    public void sortByPrice() {
        Necklace sorted = new Necklace(
                "Test",
                new Jewel("Amethyst", 0.7, 60000, 1.543),
                new Jewel("Aquamarine", 0.4, 70000, 1.564),
                new Jewel("Diamond", 0.5, 100000, 2.418));
        necklaceUtil.sortByPrice();
        assertThat(necklace, equalTo(sorted));
    }

    @Test
    public void findByRefractiveIndexBetween() {
        List<Jewel> expected = new ArrayList<>();
        expected.add( new Jewel("Amethyst", 0.7, 60000, 1.543));
        expected.add(new Jewel("Aquamarine", 0.4, 70000, 1.564));

        assertThat(necklaceUtil.findByRefractiveIndexBetween(1.3, 1.6), equalTo(expected));
    }
}