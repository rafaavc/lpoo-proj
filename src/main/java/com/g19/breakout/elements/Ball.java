package com.g19.breakout.elements;

public class Ball extends Element {
    private Direction direction;
    private double velocity;
    public enum HIT {TOP, BOTTOM, LEFT, RIGHT, PLAYERBAR, TILE, NOTHING};

    public Ball(Position position) {
        super(position);
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

    public String getStringRep() {
        return "██";
    }

    public String getColor() {
        return "#0000ff";
    }
}
