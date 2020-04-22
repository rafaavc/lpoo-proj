package com.g19.breakout.elements;

public class Ball extends Element {
    Direction direction;

    public Ball(Position position) {
        super(position);
        this.direction = new Direction(0, -1); // the ball starts by going upwards
    }

    public Direction getDirection() {
        return direction;
    }
}
