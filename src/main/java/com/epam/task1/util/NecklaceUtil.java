package com.epam.task1.util;

import com.epam.task1.model.Jewel;
import com.epam.task1.model.Necklace;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NecklaceUtil {
    private static final Logger log = Logger.getLogger(NecklaceUtil.class);

    private Necklace necklace;

    public NecklaceUtil(){}

    public void setNecklace(Necklace necklace) {
        this.necklace = necklace;
    }

    public double summaryWeight(){
        log.debug("Called for " + necklace);
        double summaryWeight = 0;
        for(Jewel jewel : necklace.getJewels()){
            summaryWeight += jewel.getWeight();
        }
        return summaryWeight;
    }


    public long summaryPrice(){
        log.debug("Called for " + necklace);
        long summaryPrice = 0;
        for (Jewel jewel : necklace.getJewels()){
            summaryPrice += jewel.getPrice();
        }
        return summaryPrice;
    }

    public void sortByPrice(){
        log.debug("Called for " + necklace);
        necklace.getJewels().sort(new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                return Long.compare(o1.getPrice(), o2.getPrice());
            }
        });
    }

    public List<Jewel> findByRefractiveIndexBetween(double from, double to){
        log.debug("Called for " + necklace + " method arguments: from = " + from + ", to = " + to);
        List<Jewel> result = new ArrayList<>();
        for (Jewel jewel : necklace.getJewels()){
           if (jewel.getRefractiveIndex() >= from && jewel.getRefractiveIndex() <= to) {
               result.add(jewel);
           }
        }
        return result;
    }
}
