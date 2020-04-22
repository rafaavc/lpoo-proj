package com.g19.breakout.elements;

import java.util.Objects;

public class Position extends XYValues {
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
}
