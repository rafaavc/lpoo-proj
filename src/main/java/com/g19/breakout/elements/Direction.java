package com.g19.breakout.elements;

import java.util.Objects;

public class Direction {
    private final double x, y;

    public Direction(double x, double y) {
        double module = Math.round(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) * 1000)/1000.;
        this.x = x/module;
        this.y = y/module;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Position getNextPosition(Position startPosition, double velocity) {
        return new Position(startPosition.getX() + velocity*x, startPosition.getY() + velocity*y);
    }

    public Direction hitTopOrBottom(){
        return new Direction(x, -y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return Double.compare(direction.x, x) == 0 &&
                Double.compare(direction.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
