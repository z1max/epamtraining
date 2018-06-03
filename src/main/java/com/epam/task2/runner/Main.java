package com.epam.task2.runner;

import com.epam.task2.model.TextUnit;
import com.epam.task2.parser.Parser;
import com.epam.task2.parser.PatternParser;
import com.epam.task2.parser.SentenceParser;
import com.epam.task2.parser.TextParser;
import com.epam.task2.util.FileUtil;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) {
        ResourceBundle bundle = PropertyResourceBundle.getBundle("task2/regexp");

        Parser root = new TextParser(new PatternParser(bundle.getString("paragraph"),
                new PatternParser(bundle.getString("sentence"), new SentenceParser())));

        FileUtil fileUtil = new FileUtil();
        String input = fileUtil.loadStringFromFile("/home/z1max/IdeaProjects/epamtraining/src/main/resources/task2/tmp.txt");
        TextUnit result =  root.parse(input);
    }
}
