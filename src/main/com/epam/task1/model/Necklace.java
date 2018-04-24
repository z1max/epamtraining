package main.com.epam.task1.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Necklace {
    private List<Jewel> jewels;

    public Necklace(){
        this.jewels = new ArrayList<>();
    }

    public Necklace(List<Jewel> jewels) {
        this.jewels = jewels;
    }

    public Necklace(Jewel... jewels){
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

    @Override
    public String toString() {
        return this.getClass().getName() + "{jewels=" + jewels + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Necklace necklace = (Necklace) o;
        return Objects.equals(jewels, necklace.jewels);
    }

    @Override
    public int hashCode() {

        return Objects.hash(jewels);
    }
}
