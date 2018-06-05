package com.epam.task2.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtil {

    public String excludeMaxLengthSubstring(String target, char startsWith, char endsWith){
        Pattern sentencePattern = Pattern.compile(RegexpUtil.getPattern("sentence"));
        Matcher sentenceMatcher = sentencePattern.matcher(target);
        StringBuilder result = new StringBuilder();
        while(sentenceMatcher.find()){
            int end = sentenceMatcher.end();
            int endIndex = end == target.length() ? end : end + 1;
            String sentence = target.substring(sentenceMatcher.start(), endIndex);
            String processed = sentence.replaceFirst(startsWith + ".*" + endsWith, "");
            result.append(processed);
        }
        return result.toString();
    }

    public String excludeWordsStartsWithConsonant(String target, int length){
        String regexp = "\\s[b-df-hj-np-tv-z][a-z]{" + (length - 1)  + "}\\s";
        return target.replaceAll(regexp, " ");
    }
}
