package com.g19.breakout.model;

import com.g19.breakout.model.utilities.Dimensions;
import com.g19.breakout.model.utilities.Direction;
import com.g19.breakout.model.utilities.Position;

public class BallModel extends ElementModel {
    private Direction direction;
    private final double velocity;


    public BallModel(Position position, double startVelocity) {
        super(position, new Dimensions(2, 1));
        this.direction = new Direction(0, -1); // the ball starts by going upwards
        velocity = startVelocity;
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
}
