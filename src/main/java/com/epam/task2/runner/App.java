package com.epam.task2.runner;

import com.epam.task2.model.TextUnit;
import com.epam.task2.parser.Parser;
import com.epam.task2.parser.PatternParser;
import com.epam.task2.parser.SentenceParser;
import com.epam.task2.parser.TextParser;
import com.epam.task2.util.FileUtil;
import com.epam.task2.util.RegexpUtil;
import com.epam.task2.util.TextUtil;
import org.apache.log4j.Logger;

public class App {

    private final static Logger LOG = Logger.getLogger(App.class);

    public static void main(String[] args) {
        String paragraphPattern = RegexpUtil.getPattern("paragraph");
        String sentencePattern = RegexpUtil.getPattern("sentence");

        Parser root = new TextParser(new PatternParser(paragraphPattern,
                new PatternParser(sentencePattern, new SentenceParser())));

        FileUtil fileUtil = new FileUtil();
        String input = fileUtil.loadStringFromFile("/home/z1max/IdeaProjects/epamtraining/src/main/resources/task2/tmp.txt");
        TextUnit result =  root.parse(input);

        LOG.info(result.getContent());

        TextUtil textUtil = new TextUtil();
        String excludedMaxLengthSubstring = textUtil.excludeMaxLengthSubstring(input, 'a', 'b');
        String excludedWordsStartsWithConsonant = textUtil.excludeWordsStartsWithConsonant(input, 3);

        LOG.info(excludedMaxLengthSubstring);
        LOG.info(excludedWordsStartsWithConsonant);

    }
}
