package com.g19.breakout.controller.ball;

import com.g19.breakout.elements.Direction;
import com.g19.breakout.model.BallModel;

public class BallHitBottom implements BallHit {
    private final BallModel ball;

    public BallHitBottom(BallModel ball) {
        this.ball = ball;
    }

    public void updateDirection() {
        ball.setDirection(new Direction(0, 0));
    }
}
