package com.g19.breakout.model;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Direction;
import com.g19.breakout.elements.Position;

public class BallModel extends Element {
    private Direction direction;
    private double velocity;
    public enum HIT {TOP, BOTTOM, LEFT, RIGHT, PLAYERBARMIDDLE, PLAYERBARLEFT, PLAYERBARRIGHT, TILE, NOTHING};

    public BallModel(Position position, String color) {
        super(position, "██", color, new Dimensions(2, 1));
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
