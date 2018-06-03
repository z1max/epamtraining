package com.epam.task2.model;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeListing implements TextUnit {
    private String content;
    ResourceBundle bundle = PropertyResourceBundle.getBundle("task2/regexp");

    public CodeListing(){}

    public CodeListing(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public TextUnit parse(String string) {
        Pattern pattern = Pattern.compile(bundle.getString("code"));
        Matcher matcher = pattern.matcher(string);
        TextUnitComposite composite = new TextUnitComposite();
        while(matcher.find()){
            composite.add(new CodeListing(string.substring(matcher.start(), matcher.end())));
        }
        return composite;
    }
}
