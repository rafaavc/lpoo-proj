package com.g19.breakout.elements;

import java.util.Objects;

public class XYValues {
    protected double x, y;

    public XYValues(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getDiscreteX() {
        return (int) Math.round(x);
    }

    public int getDiscreteY() {
        return (int) Math.round(y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XYValues xyValues = (XYValues) o;
        return Double.compare(xyValues.x, x) == 0 &&
                Double.compare(xyValues.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
