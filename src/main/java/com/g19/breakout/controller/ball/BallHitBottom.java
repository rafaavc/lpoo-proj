package com.g19.breakout.controller.ball;

import com.g19.breakout.elements.Direction;
import com.g19.breakout.model.BallModel;

public class BallHitBottom extends BallHit {

    public BallHitBottom(BallModel ball, BallHit ballHit) {
        super(ball, ballHit);
    }

    public void updateDirection() {
        ball.setDirection(new Direction(0, 0));
        if (ballHit != null) ballHit.updateDirection();
    }
}
