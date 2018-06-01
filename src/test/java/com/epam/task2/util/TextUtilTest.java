package com.epam.task2.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextUtilTest {

    private final static String TARGET1 = "I think you’ll agree that this version of addSpitter() is significantly simpler. There’s no more connection or statement-creation code—and no more exception-handling code. There’s nothing but pure data-insertion goodness.\n" +
            "Just because you don’t see a lot of boilerplate code doesn’t mean it’s not there. It’s cleverly hidden in the JDBC template class. When the update() method is called, JdbcTemplate gets a connection, creates a statement, and executes the insert SQL.\n" +
            "What you also don’t see is how the SQLException is handled. Internally, JdbcTemplate catches any SQLExceptions that may be thrown. It then translates the generic SQLException into one of the more specific data-access exceptions from table 10.1 and rethrows it. Because Spring’s data-access exceptions are all runtime exceptions, you don’t have to catch them in the addSpitter() method.";

    private static final String TARGET2 = "All that a JdbcTemplate needs in order to do its work is a DataSource . This makes it easy enough to configure a JdbcTemplate bean in Spring with the following @Bean method:";


    @Test
    public void excludeMaxLengthSubstring() {
        TextUtil textUtil = new TextUtil();
        String actual = textUtil.excludeMaxLengthSubstring(TARGET1, 'a', 'b');
        assertEquals(actual, "I think you’ll agree that this version of addSpitter() is significantly simpler. There’s no more connection or statement-creation code—and no more exception-handling code. There’s nothing but pure data-insertion goodness.\n" +
                "Just becoilerplate code doesn’t mean it’s not there. It’s cleverly hidden in the JDBC template class. When the updcTemplate gets a connection, creates a statement, and executes the insert SQL.\n" +
                "What you also don’t see is how the SQLException is handled. Interne thrown. It then trle 10.1Because Spring’s data-access exceptions are all runtime exceptions, you don’t have to catch them in the addSpitter() method.");
    }

    @Test
    public void excludeWordsStartsWithConsonantTest(){
        TextUtil textUtil = new TextUtil();
        String actual = textUtil.excludeWordsStartsWithConsonant(TARGET2, 4);
        assertEquals(actual, "All a JdbcTemplate needs in order to do its is a DataSource . This makes it easy enough to configure a JdbcTemplate in Spring the following @Bean method:");
    }
}