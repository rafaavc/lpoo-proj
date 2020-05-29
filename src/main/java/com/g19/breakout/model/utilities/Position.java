package com.g19.breakout.model.utilities;

import java.util.Objects;

public class Position extends Dimensions {
    public Position(double x, double y) {
        super(x, y);
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
        return Double.compare(position.x, x) == 0 &&
                Double.compare(position.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
