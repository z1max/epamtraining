package main.com.epam.task1.model;

import java.util.Objects;

public class Jewel {

    private String name;

    private double weight;

    // Price in cents
    private long price;

    private double refractiveIndex;

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
        return Double.compare(jewel.weight, weight) == 0 &&
                price == jewel.price &&
                Double.compare(jewel.refractiveIndex, refractiveIndex) == 0 &&
                Objects.equals(name, jewel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, price, refractiveIndex);
    }
}
