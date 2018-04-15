package main.com.epam.task1.util;

public class PriceUtil {

    private PriceUtil(){}

    public static double centsToDollars(long cents){
        return (double) cents / 100;
    }

    public static long dollarsToCents(double dollars){
        return (long) (dollars * 100);
    }
}
