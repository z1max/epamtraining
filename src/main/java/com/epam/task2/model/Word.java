package com.epam.task2.model;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word implements TextUnit {
    private String content;
    private ResourceBundle bundle = PropertyResourceBundle.getBundle("task2/regexp");

    public Word(){}

    public Word(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public TextUnit parse(String string) {
        Pattern pattern = Pattern.compile(bundle.getString("word"));
        Matcher matcher = pattern.matcher(string);
        TextUnitComposite composite = new TextUnitComposite();
        while(matcher.find()){
            composite.add(new Word(string.substring(matcher.start(), matcher.end())));
        }
        return composite;
    }
}
