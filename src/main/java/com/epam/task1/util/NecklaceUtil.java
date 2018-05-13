package com.epam.task1.util;

import com.epam.task1.model.Jewel;
import com.epam.task1.model.Necklace;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * This class contains various methods for manipulating necklaces
 * such as searching, sorting, and getting summary information.
 */
public class NecklaceUtil {
    private static final Logger LOG = Logger.getLogger(NecklaceUtil.class);

    private Necklace necklace;

    public NecklaceUtil(){}

    public void setNecklace(Necklace necklace) {
        this.necklace = necklace;
    }

    /**
     * @return a {@code double} value - summary weight of jewels in current necklace.
     */
    public double summaryWeight(){
        LOG.debug("Called for " + necklace);
        double summaryWeight = 0;
        for(Jewel jewel : necklace.getJewels()){
            summaryWeight += jewel.getWeight();
        }
        return summaryWeight;
    }

    /**
     * @return a {@code long} value - summary price in cents of jewels in current necklace.
     */
    public long summaryPrice(){
        LOG.debug("Called for " + necklace);
        long summaryPrice = 0;
        for (Jewel jewel : necklace.getJewels()){
            summaryPrice += jewel.getPrice();
        }
        return summaryPrice;
    }

    /**
     * Sorts jewels by price in current necklace in ascending order.
     */
    public void sortByPrice(){
        LOG.debug("Called for " + necklace);
        necklace.getJewels().sort(new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                return Long.compare(o1.getPrice(), o2.getPrice());
            }
        });
    }

    /**
     * Finds jewels in current necklace that have refractive index between
     * <i>from<i/> and <i>to<i/> parameters.
     *
     * @param from the minimum refractive index to be searched (inclusive).
     * @param to   the maximum refractive index to be searched (inclusive).
     * @return a {@code List<Jewel>} - list of jewels that have refractive
     * index between <i>from<i/> and <i>to<i/> parameters.
     */
    public List<Jewel> findByRefractiveIndexBetween(double from, double to){
        LOG.debug("Called for " + necklace + " method arguments: from = " + from + ", to = " + to);
        List<Jewel> result = new ArrayList<>();
        for (Jewel jewel : necklace.getJewels()){
           if (jewel.getRefractiveIndex() >= from && jewel.getRefractiveIndex() <= to) {
               result.add(jewel);
           }
        }
        return result;
    }
}
