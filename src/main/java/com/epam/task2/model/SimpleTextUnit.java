package com.epam.task2.model;

public class SimpleTextUnit implements TextUnit {

    private String content;

    public SimpleTextUnit(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}
