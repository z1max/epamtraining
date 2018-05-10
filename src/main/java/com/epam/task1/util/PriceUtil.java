package com.epam.task1.util;

import org.apache.log4j.Logger;

public class PriceUtil {
    private static final Logger log = Logger.getLogger(PriceUtil.class);

    private PriceUtil(){}

    public static double centsToDollars(long cents){
        log.debug("method argument: cents = " + cents);
        return (double) cents / 100;
    }

    public static long dollarsToCents(double dollars){
        log.debug("method argument: dollars =  " + dollars);
        return (long) (dollars * 100);
    }
}
