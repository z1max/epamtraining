package com.epam.task4.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The {@code Necklace} class represents necklace
 * that has name and list of jewels.
 *
 * Contains following fields:
 * <i>name<i/> - the name of necklace, type {@code String},
 * <i>jewels<i/> - list of jewels, type {@code List<Jewel>}.
 *
 * In addition, contains constructor, getters and setters,
 * overrides toString, equals and hashCode methods.
 */
public class Necklace {
    private String name;

    private List<Jewel> jewels;

    public Necklace(){
        this.name = "";
        this.jewels = new ArrayList<>();
    }

    public Necklace(String name){
        this.name = name;
        this.jewels = new ArrayList<>();
    }

    public Necklace(String name, List<Jewel> jewels) {
        this.name = name;
        this.jewels = jewels;
    }

    public Necklace(String name, Jewel... jewels){
        this.name = name;
        this.jewels = Arrays.asList(jewels);
    }

    public List<Jewel> getJewels() {
        return jewels;
    }

    public void setJewels(List<Jewel> jewels) {
        this.jewels = jewels;
    }

    public void addJewel(Jewel jewel){
        jewels.add(jewel);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "{name='" + name + "', jewels=" + jewels + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Necklace necklace = (Necklace) o;
        return name.equals(necklace.name) &&
                jewels.equals(necklace.jewels);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (name == null ? 0 : name.hashCode());
        for (Jewel next : jewels) {
            hash = 31 * hash + (next == null ? 0 : next.hashCode());
        }
        return hash;
    }
}
