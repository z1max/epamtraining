package test.com.emap.task1.util;

import main.com.epam.task1.model.Jewel;
import main.com.epam.task1.model.Necklace;
import main.com.epam.task1.util.NecklaceUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class NecklaceUtilTest {

    private Necklace necklace;

    @Before
    public void setUp() throws Exception {
        necklace = new Necklace(
                new Jewel("Diamond", 0.5, 100000, 2.418),
                new Jewel("Amethyst", 0.7, 60000, 1.543),
                new Jewel("Aquamarine", 0.4, 70000, 1.564));
    }

    @After
    public void tearDown() throws Exception {
        necklace = null;
    }

    @Test
    public void summaryWeight() {
        assertThat(NecklaceUtil.summaryWeight(necklace), equalTo(1.6));
    }

    @Test
    public void summaryPrice() {
        assertThat(NecklaceUtil.summaryPrice(necklace), equalTo(230000L));
    }

    @Test
    public void sortByPrice() {
        Necklace sorted = new Necklace(
                new Jewel("Amethyst", 0.7, 60000, 1.543),
                new Jewel("Aquamarine", 0.4, 70000, 1.564),
                new Jewel("Diamond", 0.5, 100000, 2.418));
        NecklaceUtil.sortByPrice(necklace);
        assertThat(necklace, equalTo(sorted));
    }

    @Test
    public void findByRefractiveIndexBetween() {
        List<Jewel> expected = new ArrayList<>();
        expected.add( new Jewel("Amethyst", 0.7, 60000, 1.543));
        expected.add(new Jewel("Aquamarine", 0.4, 70000, 1.564));

        assertThat(NecklaceUtil.findByRefractiveIndexBetween(necklace, 1.3, 1.6), equalTo(expected));
    }
}