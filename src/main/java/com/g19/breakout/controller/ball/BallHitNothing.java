package com.g19.breakout.controller.ball;

import com.g19.breakout.model.BallModel;

public class BallHitNothing implements BallHit {
    private BallModel ball;
    private BallHit ballHit = null;

    public BallHitNothing(BallModel ball) {
        this.ball = ball;
    }

    public BallHitNothing(BallModel ball, BallHit ballHit) {
        this.ball = ball;
        this.ballHit = ballHit;
    }

    @Override
    public void updateDirection() {
        if (ballHit != null) ballHit.updateDirection();
    }
}
