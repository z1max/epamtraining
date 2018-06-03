package com.epam.task2.parser;

import com.epam.task2.model.CodeListing;
import com.epam.task2.model.TextUnit;
import com.epam.task2.model.TextUnitComposite;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser implements Parser {

    private Parser next;
    ResourceBundle bundle = PropertyResourceBundle.getBundle("task2/regexp");

    public TextParser(Parser next) {
        this.next = next;
    }

    public void setNext(Parser next) {
        this.next = next;
    }

    @Override
    public TextUnit parse(String string) {
        int start = 0;
        int end = string.length();

        Pattern pattern = Pattern.compile(bundle.getString("code"));
        Matcher matcher = pattern.matcher(string);

        TextUnitComposite composite = new TextUnitComposite();


        int startMatch;
        int endMatch = -1;
        while (matcher.find()){
            startMatch = matcher.start();
            endMatch = matcher.end();
            if (startMatch != start){
                composite.add(next.parse(string.substring(start, startMatch)));
                start = endMatch;
            }
            composite.add(new CodeListing().parse(string.substring(startMatch, endMatch)));
        }

        if (endMatch != -1 && endMatch != end){
            composite.add(next.parse(string.substring(endMatch, end)));
        }

        return composite;
    }
}
