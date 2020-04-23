package com.g19.breakout.controller.ball;

import com.g19.breakout.elements.Direction;
import com.g19.breakout.model.BallModel;

public class BallHitBottom implements BallHit {
    private BallModel ball;
    private BallHit ballHit = null;

    public BallHitBottom(BallModel ball) {
        this.ball = ball;
    }

    public BallHitBottom(BallModel ball, BallHit ballHit) {
        this.ball = ball;
        this.ballHit = ballHit;
    }

    @Override
    public void updateDirection() {
        ball.setDirection(new Direction(0, 0));
        if (ballHit != null) ballHit.updateDirection();
    }
}
