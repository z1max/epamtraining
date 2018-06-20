package com.epam.task3.util;

import java.util.Random;

public final class RandomUtil {
    private static Random random = new Random();

    public static int getIntBetween(int from, int to){
        return from + random.nextInt(to - from + 1);
    }

    public static boolean getRandomBoolean(){
        return random.nextBoolean();
    }
}
