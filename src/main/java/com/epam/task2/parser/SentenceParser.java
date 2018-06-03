package com.epam.task2.parser;

import com.epam.task2.model.TextUnit;
import com.epam.task2.model.Word;

public class SentenceParser implements Parser {

    @Override
    public TextUnit parse(String string) {
        return new Word().parse(string);
    }
}
