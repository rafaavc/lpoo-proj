package com.g19.breakout.controller.ball;

import com.g19.breakout.elements.Direction;
import com.g19.breakout.model.BallModel;

public class BallHitBottom extends BallHit {
    public BallHitBottom(BallModel ball) {
        super(ball);
    }

    public void updateDirection() {
        ball.setDirection(new Direction(0, 0));
    }
}
