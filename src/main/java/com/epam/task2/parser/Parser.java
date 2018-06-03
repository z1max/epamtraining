package com.epam.task2.parser;

import com.epam.task2.model.TextUnit;

public interface Parser {
    TextUnit parse(String string);
}
