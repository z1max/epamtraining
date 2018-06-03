package com.epam.task2.parser;

import com.epam.task2.model.TextUnit;
import com.epam.task2.model.TextUnitComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternParser implements Parser {

    private String pattern;
    private Parser next;

    public PatternParser(String pattern, Parser next){
        this.pattern = pattern;
        this.next = next;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public void setNext(Parser parser){
        this.next = parser;
    }

    @Override
    public TextUnit parse(String string) {
        Pattern pattern = Pattern.compile(this.pattern);
        Matcher matcher = pattern.matcher(string);

        TextUnitComposite composite = new TextUnitComposite();

        while(matcher.find()){
            if (next != null) {
                composite.add(next.parse(string.substring(matcher.start(), matcher.end())));
            }
        }

        return composite;
    }
}
