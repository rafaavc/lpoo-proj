package com.g19.breakout.controller.ball;

import com.g19.breakout.model.BallModel;

public class BallHitNothing extends BallHit {
    private final BallHit ballHit;

    public BallHitNothing(BallModel ball, BallHit ballHit) {
        super(ball);
        this.ballHit = ballHit;
    }

    public void updateDirection() {
        if (ballHit != null) ballHit.updateDirection();
    }
}
