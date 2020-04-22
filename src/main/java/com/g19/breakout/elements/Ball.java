package com.g19.breakout.elements;

public class Ball extends Element {
    private Direction direction;
    private double velocity;

    public Ball(Position position, String color) {
        super(position, "██", color);
        this.direction = new Direction(0, -1); // the ball starts by going upwards
        velocity = 10;
    }

    public double getVelocity() {
        return velocity;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }
}
