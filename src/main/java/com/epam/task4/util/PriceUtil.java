package com.epam.task4.util;

import org.apache.log4j.Logger;

/**
 * This class contains two methods for converting some amount of money.
 */
public class PriceUtil {
    private static final Logger LOG = Logger.getLogger(PriceUtil.class);

    private PriceUtil(){}

    /**
     * Converts some amount of money in cents to a {@code double} value
     * that represents the same amount in dollars and cents.
     *
     * @param   cents a {@code long} value. Amount in dollars.
     * @return  a {@code double} value. Amount in dollars.
     */
    public static double centsToDollars(long cents){
        LOG.debug("method argument: cents = " + cents);
        return (double) cents / 100;
    }

    /**
     * Converts some amount of money in dollars and cents to a {@code long} value
     * that represents the same amount in cents.
     *
     * @param dollars a {@code double} value. Amount in dollars and cents.
     * @return a {@code long} value. Amount in cents.
     */
    public static long dollarsToCents(double dollars){
        LOG.debug("method argument: dollars =  " + dollars);
        return (long) (dollars * 100);
    }
}
