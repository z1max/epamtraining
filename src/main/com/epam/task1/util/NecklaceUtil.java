package main.com.epam.task1.util;

import main.com.epam.task1.model.Jewel;
import main.com.epam.task1.model.Necklace;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NecklaceUtil {

    private NecklaceUtil(){}

    public static double summaryWeight(Necklace necklace){
        return necklace.getJewels().stream()
                .mapToDouble(Jewel::getWeight)
                .sum();
    }


    public static long summaryPrice(Necklace necklace){
        return necklace.getJewels().stream()
                .mapToLong(Jewel::getPrice)
                .sum();
    }

    public static void sortByPrice(Necklace necklace){
        necklace.getJewels().sort(Comparator.comparing(Jewel::getPrice));
    }

    public static List<Jewel> findByRefractiveIndexBetween(Necklace necklace, double from, double to){
        return necklace.getJewels().stream()
                .filter(jewel -> jewel.getRefractiveIndex() >= from && jewel.getRefractiveIndex() <= to)
                .collect(Collectors.toList());
    }
}
