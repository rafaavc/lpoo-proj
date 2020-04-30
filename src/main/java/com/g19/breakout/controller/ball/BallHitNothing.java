package com.g19.breakout.controller.ball;

import com.g19.breakout.model.BallModel;

public class BallHitNothing extends BallHit {

    public BallHitNothing(BallModel ball, BallHit ballHit) {
        super(ball, ballHit);
    }

    public void updateDirection() {
        if (ballHit != null) ballHit.updateDirection();
    }
}
