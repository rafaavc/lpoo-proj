package com.g19.breakout.elements;

public class Position extends Dimensions {
    public Position(double x, double y) {
        super(x, y);
    }

    public Position left() {
        return new Position(x-2, y);
    }

    public Position right() {
        return new Position(x+2, y);
    }

    public Position up() {
        return new Position(x, y-1);
    }

    public Position down() {
        return new Position(x, y+1);
    }
}
