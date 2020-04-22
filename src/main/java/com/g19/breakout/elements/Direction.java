package com.g19.breakout.elements;

import java.util.Objects;

public class Direction extends XYValues {
    Direction(double x, double y) {
        super(x, y);
        double module = Math.round(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) * 1000)/1000.;
        this.x = x/module;
        this.y = y/module;
    }

    public Position getNextPosition(Position startPosition, double velocity) {
        return new Position(startPosition.getX() + velocity*x, startPosition.getY() + velocity*y);
    }
}
