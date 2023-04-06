package com.my.water;

import java.util.Objects;

public class Price {
    private int start;
    private int end;
    private double price;

    public Price(int start, int end, double price) {
        this.start = start;
        this.end = end;
        this.price = price;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return start == price1.start && end == price1.end && Double.compare(price1.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, price);
    }
}
