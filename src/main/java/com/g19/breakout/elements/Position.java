package com.g19.breakout.elements;

import java.util.Objects;

public class Position {
    private final double x, y;

    public Position(double x, double y) {
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

    public Position left() {
        return new Position(x-1, y);
    }

    public Position right() {
        return new Position(x+1, y);
    }

    public Position up() {
        return new Position(x, y-1);
    }

    public Position down() {
        return new Position(x, y+1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
