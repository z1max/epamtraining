package com.epam.task1.model;

/**
 * The {@code Jewel} class represent a jewel.
 *
 * Contains following fields:
 * <i>name<i/> - the name of jewel, type {@code String},
 * <i>weight<i/> - the weight of jewel in carats, type {@code double},
 * <i>price<i/> - the price of jewel in cents, type {@code long},
 * <i>refractiveIndex<i/> - the refractive index of jewel, type {@code double}.
 *
 * In addition, contains constructor, getters and setters,
 * overrides toString, equals and hashCode methods.
 */
public class Jewel {

    private String name;

    private double weight;

    // Price in cents
    private long price;

    private double refractiveIndex;

    public Jewel(String name){
        this.name = name;
    }

    public Jewel(String name, double weight, long price, double refractiveIndex) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.refractiveIndex = refractiveIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public double getRefractiveIndex() {
        return refractiveIndex;
    }

    public void setRefractiveIndex(double refractiveIndex) {
        this.refractiveIndex = refractiveIndex;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(this.getClass().getName() + "{");
        sb.append("name='").append(name).append('\'');
        sb.append(", weight=").append(weight);
        sb.append(", price=").append(price);
        sb.append(", refractiveIndex=").append(refractiveIndex);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jewel jewel = (Jewel) o;
        return name.equals(jewel.name) &&
                Double.compare(jewel.weight, weight) == 0 &&
                price == jewel.price &&
                Double.compare(jewel.refractiveIndex, refractiveIndex) == 0;
    }

    @Override
    public int hashCode() {
        long weightBits = Double.doubleToLongBits(weight);
        long refractiveIndexBits = Double.doubleToLongBits(refractiveIndex);

        int hash = 7;
        hash = 31 * hash + (name == null ? 0 : name.hashCode());
        hash = 31 * hash + (int)(weightBits ^ (weightBits >>> 32));
        hash = 31 * hash + (int)(price ^ (price >>> 32));
        hash = 31 * hash + (int)(refractiveIndexBits ^ (refractiveIndexBits >>> 32));
        return hash;
    }
}
