package com.epam.task2.util;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class RegexpUtil {

    private static final ResourceBundle BUNDLE = PropertyResourceBundle.getBundle("task2/regexp");

    public static String getPattern(String name){
        return BUNDLE.getString(name);
    }
}
