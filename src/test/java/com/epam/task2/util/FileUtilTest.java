package com.epam.task2.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileUtilTest {

    @Test
    public void loadStringFromFile() {
        FileUtil fileUtil = new FileUtil();
        String result = fileUtil.loadStringFromFile("/home/z1max/IdeaProjects/epamtraining/src/main/resources/task2-input-file.txt");
        System.out.println(result);
    }
}