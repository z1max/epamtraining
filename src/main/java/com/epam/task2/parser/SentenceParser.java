package com.epam.task2.parser;

import com.epam.task2.model.SimpleTextUnit;
import com.epam.task2.model.TextUnit;
import com.epam.task2.model.TextUnitComposite;
import com.epam.task2.util.RegexpUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements Parser {

    @Override
    public TextUnit parse(String string) {
        Pattern pattern = Pattern.compile(RegexpUtil.getPattern("word"));
        Matcher matcher = pattern.matcher(string);
        TextUnitComposite composite = new TextUnitComposite();
        while (matcher.find()){
            composite.add(new SimpleTextUnit(string.substring(matcher.start(), matcher.end())));
        }
        return composite;
    }
}
