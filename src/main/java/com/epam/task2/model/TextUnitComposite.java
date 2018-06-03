package com.epam.task2.model;

import java.util.ArrayList;
import java.util.List;

public class TextUnitComposite implements TextUnit {

    List<TextUnit> children;

    public TextUnitComposite(){
        children = new ArrayList<>();
    }

    public void add(TextUnit textUnit){
        children.add(textUnit);
    }

    @Override
    public TextUnit parse(String string) {
        TextUnitComposite result = new TextUnitComposite();
        for (TextUnit next : children){
            result.add(next.parse(string));
        }
        return result;
    }
}