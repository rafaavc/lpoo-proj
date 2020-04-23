package com.g19.breakout.controller.ball;

import com.g19.breakout.elements.Direction;
import com.g19.breakout.model.BallModel;

public class BallHitPlayerBarMiddle implements BallHit {
    private BallModel ball;
    private BallHit ballHit = null;

    public BallHitPlayerBarMiddle(BallModel ball) {
        this.ball = ball;
    }

    public BallHitPlayerBarMiddle(BallModel ball, BallHit ballHit) {
        this.ball = ball;
        this.ballHit = ballHit;
    }

    @Override
    public void updateDirection() {
        ball.setDirection(new Direction(0, -1));
        if (ballHit != null) ballHit.updateDirection();
    }
}
