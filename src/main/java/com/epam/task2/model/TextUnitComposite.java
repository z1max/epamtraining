package com.epam.task2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class TextUnitComposite implements TextUnit {

    List<TextUnit> children;

    public TextUnitComposite(){
        children = new ArrayList<>();
    }

    public void add(TextUnit textUnit){
        children.add(textUnit);
    }

    @Override
    public String getContent() {
        StringJoiner joiner = new StringJoiner(" ");
        children.forEach(child -> joiner.add(child.getContent()));
        return joiner.toString();
    }
}