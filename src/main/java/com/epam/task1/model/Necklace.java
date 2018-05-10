package com.epam.task1.model;

import java.util.*;

public class Necklace {
    private String name;

    private List<Jewel> jewels;

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
        return this.getClass().getName() + "{name=" + name + "jewels=" + jewels + '}';
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
        Iterator<Jewel> iterator = jewels.iterator();
        while (iterator.hasNext()){
            Jewel next = iterator.next();
            hash = 31 * hash + (next == null ? 0 : next.hashCode());
        }
        return hash;
    }
}
