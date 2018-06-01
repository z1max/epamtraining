package com.epam.task1.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class PriceUtilTest {

    private Map<Long, Double> testData = new HashMap<>();

    @Before
    public void setUp() throws Exception {
        testData.put(100L, 1d);
        testData.put(1000L, 10d);
        testData.put(1230L, 12.30d);
        testData.put(12575L, 125.75d);
    }

    @After
    public void tearDown() throws Exception {
        testData.clear();
    }

    @Test
    public void centsToDollars() {
        testData.forEach((key, value) -> assertThat(PriceUtil.centsToDollars(key), equalTo(value)));
    }

    @Test
    public void dollarsToCents() {
        testData.forEach((key, value) -> assertThat(PriceUtil.dollarsToCents(value), equalTo(key)));
    }
}